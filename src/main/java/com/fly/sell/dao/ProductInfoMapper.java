package com.fly.sell.dao;

import com.fly.sell.entity.ProductInfo;

import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer id);

    List<ProductInfo> selectAll();

    List<ProductInfo> selectAllOnSelf();

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}