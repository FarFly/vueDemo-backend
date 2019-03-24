package com.fly.sell.dao;

import com.fly.sell.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer id);

    Integer pageQueryCount();

    List<ProductInfo> pageQuery(@Param("index") Integer index, @Param("size") Integer size);

    List<ProductInfo> selectAll();

    List<ProductInfo> selectAllOnSelf();

    List<ProductInfo> batchQueryByIds(@Param("ids") List<Integer> ids);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}