package com.fly.sell.service;

import com.fly.sell.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> selectAll();

    ProductCategory selectByPrimaryKey(Integer id);

    void insert(ProductCategory productCategory);

    void update(ProductCategory productCategory);
}
