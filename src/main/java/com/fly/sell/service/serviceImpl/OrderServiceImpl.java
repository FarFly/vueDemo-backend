package com.fly.sell.service.serviceImpl;

import com.fly.sell.common.LocalStore;
import com.fly.sell.dao.OrderDetailMapper;
import com.fly.sell.dao.OrderMasterMapper;
import com.fly.sell.dao.ProductInfoMapper;
import com.fly.sell.entity.OrderDetail;
import com.fly.sell.entity.OrderMaster;
import com.fly.sell.entity.ProductInfo;
import com.fly.sell.exception.SellException;
import com.fly.sell.form.ItemsForm;
import com.fly.sell.form.ProductForm;
import com.fly.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static String orderpre = "order";

    @Override
    @Transactional
    public void createOrder(ProductForm productForm, Integer tableId){
        // 上锁
        if(redisTemplate.opsForValue().setIfAbsent(orderpre+"tableId", "userId", 10000, TimeUnit.MILLISECONDS)){
            // 在productInfo表中查看库存 (采取批量查询)
            List<ItemsForm> items = productForm.getItems();
            List<Integer> itemsProductIds = items.stream().map(ItemsForm::getProductId).collect(Collectors.toList());
            List<ProductInfo> productInfos = productInfoMapper.batchQueryByIds(itemsProductIds);
            // 检查库存 并计算总价格 并构建订单详情
            Map<Integer, Integer> itemsMap = items.stream().collect(Collectors.toMap(ItemsForm::getProductId, ItemsForm::getProductQuantity));
            StringBuilder sb = new StringBuilder();
            BigDecimal orderAmount = new BigDecimal(0);
            List<OrderDetail> orderDetailList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos){
                Integer orderNumber = itemsMap.get(productInfo.getId());
                if(orderNumber > productInfo.getStock()){
                    sb.append("商品'").append(productInfo.getName()).append("'库存不足，");
                }
                orderAmount = orderAmount.add(productInfo.getPrice().multiply(new BigDecimal(orderNumber)));
                // 订单详情
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProductId(productInfo.getId());
                orderDetail.setProductName(productInfo.getName());
                orderDetail.setProductIcon(productInfo.getIcon());
                orderDetail.setProductPrice(productInfo.getPrice());
                orderDetail.setProductQuantity(orderNumber);
                orderDetailList.add(orderDetail);
            }
            if(sb.length() > 0){
                sb.deleteCharAt(sb.lastIndexOf("，"));
                throw new SellException(10, sb.toString());
            }

            if(!orderDetailList.isEmpty()){
                // 全部库存ok后，创建订单主表
                OrderMaster orderMaster = new OrderMaster();
                orderMaster.setOrderAmount(orderAmount);
//              orderMaster.setTableId(tableId);
                orderMaster.setTableId(1);
                orderMasterMapper.insertSelective(orderMaster);
                // 完善订单详情
                orderDetailList.stream().forEach(e->e.setOrderId(orderMaster.getId()));
                orderDetailMapper.batchInsert(orderDetailList);
            }
            // 释放锁
            redisTemplate.delete(orderpre+"tableId");
        }else{
            throw new SellException(11,"当前下订单的人数过多，请稍后重试");
        }
    }

}
