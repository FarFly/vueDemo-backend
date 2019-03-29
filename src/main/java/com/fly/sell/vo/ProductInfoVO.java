package com.fly.sell.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfoVO {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer stock;

    private String info;

    private String icon;

    private String image;

    private Byte status;

    private Integer categoryId;

    private BigDecimal oldPrice;

    private String description;

    private Double rating;
}
