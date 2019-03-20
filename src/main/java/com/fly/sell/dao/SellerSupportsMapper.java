package com.fly.sell.dao;

import com.fly.sell.entity.SellerSupports;

import java.util.List;

public interface SellerSupportsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellerSupports record);

    int insertSelective(SellerSupports record);

    SellerSupports selectByPrimaryKey(Integer id);

    List<SellerSupports> selectBySellId(Integer id);

    int updateByPrimaryKeySelective(SellerSupports record);

    int updateByPrimaryKey(SellerSupports record);
}