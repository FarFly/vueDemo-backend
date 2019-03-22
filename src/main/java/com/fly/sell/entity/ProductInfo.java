package com.fly.sell.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class ProductInfo {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer stock;

    private String info;

    private String icon;

    private Byte status;

    private Integer categoryId;

    private Date createTime;

    private Date updateTime;

    private BigDecimal oldPrice;

    private String description;

    private Double rating;

    private Integer sellCount;

    private String image;
}