package com.fly.sell.dao;

import com.fly.sell.entity.SellerMaster;

public interface SellerMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellerMaster record);

    int insertSelective(SellerMaster record);

    SellerMaster selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellerMaster record);

    int updateByPrimaryKey(SellerMaster record);
}