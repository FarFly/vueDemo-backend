package com.fly.sell.constant;

/**
 * redis常量
 * Created by 廖师兄
 * 2017-07-30 16:22
 */
public interface RedisConstant {

    String LOGIN_TOKEN_PREFIX = "token_login_%s";
    String TABLE_TOKEN_PREFIX = "token_table_%s";

    Integer EXPIRE = 7200; //2小时
}
