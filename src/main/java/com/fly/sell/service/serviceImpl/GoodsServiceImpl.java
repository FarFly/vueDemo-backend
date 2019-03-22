package com.fly.sell.service.serviceImpl;

import com.fly.sell.dao.ProductCategoryMapper;
import com.fly.sell.dao.ProductInfoMapper;
import com.fly.sell.entity.ProductCategory;
import com.fly.sell.entity.ProductInfo;
import com.fly.sell.service.GoodsService;
import com.fly.sell.vo.GoodsVO;
import com.fly.sell.vo.ProductInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<GoodsVO> queryGoods(){
        List<GoodsVO> goodsVOList = new ArrayList<>();

        List<ProductCategory> productCategoryList = productCategoryMapper.selectAll();

        List<ProductInfo> productInfoOnSelfList = productInfoMapper.selectAllOnSelf();
        Map<Integer, List<ProductInfo>> productInfoOnSelfMap = productInfoOnSelfList.stream().collect(Collectors.groupingBy(ProductInfo::getCategoryId));

        for(ProductCategory productCategory : productCategoryList){
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(productCategory, goodsVO);

            List<ProductInfo> productInfoListByCategoryId = productInfoOnSelfMap.get(productCategory.getId());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoListByCategoryId){
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo, productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
            goodsVO.setFoods(productInfoVOList);
            goodsVOList.add(goodsVO);
        }

        return goodsVOList;
    }

}
