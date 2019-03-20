package com.fly.sell.vo;

import lombok.Data;

import java.util.List;

@Data
public class GoodsVO {
    private Integer id;

    private String name;

    private Integer type;

    private List<ProductInfoVO> foods;

}
