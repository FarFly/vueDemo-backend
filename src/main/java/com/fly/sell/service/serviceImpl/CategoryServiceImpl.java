package com.fly.sell.service.serviceImpl;

import com.fly.sell.dao.ProductCategoryMapper;
import com.fly.sell.entity.ProductCategory;
import com.fly.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> selectAll() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public ProductCategory selectByPrimaryKey(Integer id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void insert(ProductCategory productCategory) {
        productCategoryMapper.insertSelective(productCategory);

    }

    @Override
    @Transactional
    public void update(ProductCategory productCategory) {
        productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

}
