package com.fly.sell.service;

import com.fly.sell.form.ProductForm;

public interface OrderService {
    void createOrder(ProductForm productForm, Integer tableId);
}
