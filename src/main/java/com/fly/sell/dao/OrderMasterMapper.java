package com.fly.sell.dao;

import com.fly.sell.entity.OrderMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(Integer id);

    Integer pageQueryCount();

    List<OrderMaster> pageQuery(@Param("index") Integer index, @Param("size") Integer size);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}