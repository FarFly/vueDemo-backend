package com.fly.sell.vo;

import lombok.Data;
import java.util.List;

@Data
public class SellerVO {

    private Integer id;

    private String openid;

    private String name;

    private String description;

    private Integer deliveryTime;

    private Double score;

    private Double serviceScore;

    private Double foodScore;

    private Double rankRate;

    private Double minPrice;

    private Double deliveryPrice;

    private Integer ratingCount;

    private Integer sellCount;

    private String bulletin;

    private String avatar;

    private List<SellerSupportsVO> supports;

    private List<String> infos;
}
