package com.fly.sell.service;

import com.fly.sell.common.Page;
import com.fly.sell.entity.ProductInfo;

import java.util.List;

public interface ProductService {

    Page<List<ProductInfo>> pageQuery(Page<List<ProductInfo>> page);

    void onSale(Integer productId);

    void offSale(Integer productId);

    ProductInfo selectByPrimaryKey(Integer id);

    void insert(ProductInfo productInfo);

    void update(ProductInfo productInfo);


}
