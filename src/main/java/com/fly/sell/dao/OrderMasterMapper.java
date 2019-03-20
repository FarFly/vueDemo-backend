package com.fly.sell.dao;

import com.fly.sell.entity.OrderMaster;

public interface OrderMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}