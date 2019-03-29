package com.fly.sell.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ProductSaveForm {
    private Integer id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotNull(message = "价格必须填写")
    private BigDecimal price;

    @NotNull(message = "库存必须填写")
    private Integer stock;

    private String info;

    private String icon;

    private Integer status;

    private Integer categoryId;

    private Date createTime;

    private Date updateTime;

    private BigDecimal oldPrice;

    private String description;

    private Double rating;

    private Integer sellCount;

    private String image;

    private MultipartFile imgFile;

    private MultipartFile iconFile;

}
