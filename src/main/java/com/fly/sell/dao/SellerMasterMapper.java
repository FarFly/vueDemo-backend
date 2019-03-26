package com.fly.sell.dao;

import com.fly.sell.entity.SellerMaster;
import org.apache.ibatis.annotations.Param;

public interface SellerMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellerMaster record);

    int insertSelective(SellerMaster record);

    SellerMaster selectByPrimaryKey(Integer id);

    SellerMaster login(@Param("username") String username,
                       @Param("password") String password);

    int updateByPrimaryKeySelective(SellerMaster record);

    int updateByPrimaryKey(SellerMaster record);
}