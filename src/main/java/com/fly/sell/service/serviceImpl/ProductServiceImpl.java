package com.fly.sell.service.serviceImpl;

import com.fly.sell.common.Page;
import com.fly.sell.dao.ProductInfoMapper;
import com.fly.sell.entity.ProductInfo;
import com.fly.sell.enums.ProductStatusEnum;
import com.fly.sell.exception.SellException;
import com.fly.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public Page<List<ProductInfo>> pageQuery(Page<List<ProductInfo>> page) {
        Integer totalCount = productInfoMapper.pageQueryCount();
        page.setTotalCount(totalCount);
        if(totalCount == 0){
            page.setTotalPages(0);
            return page;
        }
        List<ProductInfo> productInfos = productInfoMapper.pageQuery(page.getIndex(), page.getSize());
        page.setData(productInfos);
        Integer totalPages = totalCount % page.getSize() == 0 ? totalCount / page.getSize() : totalCount / page.getSize() + 1;
        page.setTotalPages(totalPages);

        return page;
    }

    @Override
    @Transactional
    public void onSale(Integer productId) {
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        if(productInfo == null){
            throw  new SellException(20, "当前商品不存在");
        }

        productInfo.setStatus(ProductStatusEnum.UP.getCode());
        productInfoMapper.updateByPrimaryKeySelective(productInfo);

    }

    @Override
    @Transactional
    public void offSale(Integer productId) {
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        if(productInfo == null){
            throw  new SellException(20, "当前商品不存在");
        }

        productInfo.setStatus(ProductStatusEnum.DOWN.getCode());
        productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    @Override
    public ProductInfo selectByPrimaryKey(Integer id) {
        return productInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void insert(ProductInfo productInfo) {
        productInfoMapper.insertSelective(productInfo);
    }

    @Override
    @Transactional
    public void update(ProductInfo productInfo) {
        productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }
}
