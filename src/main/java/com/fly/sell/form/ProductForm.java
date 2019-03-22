package com.fly.sell.form;

import lombok.Data;

import java.util.List;

@Data
public class ProductForm {
    private String phone;
    private String name;
    private String address;
    private List<ItemsForm> items;

}
