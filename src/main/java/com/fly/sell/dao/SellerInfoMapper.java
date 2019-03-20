package com.fly.sell.dao;

import com.fly.sell.entity.SellerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SellerInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellerInfo record);

    int insertSelective(SellerInfo record);

    SellerInfo selectByPrimaryKey(Integer id);

    List<SellerInfo> selectBySellId(Integer id);

    int updateByPrimaryKeySelective(SellerInfo record);

    int updateByPrimaryKey(SellerInfo record);
}