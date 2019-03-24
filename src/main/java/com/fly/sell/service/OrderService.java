package com.fly.sell.service;

import com.fly.sell.common.Page;
import com.fly.sell.dto.OrderDTO;
import com.fly.sell.entity.OrderMaster;
import com.fly.sell.form.ProductForm;

import java.util.List;

public interface OrderService {
    void createOrder(ProductForm productForm, Integer tableId);

    Page<List<OrderDTO>> pageQuery(Page<List<OrderDTO>> page);

    void cancel(Integer id);

    void finish(Integer id);

    OrderDTO selectByPrimaryKey(Integer id);

}
