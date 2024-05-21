package com.example.sprdemo.service;

import com.example.sprdemo.mapper.ProductMapper;
import com.example.sprdemo.model.Product;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    public Product getById(int productId) {
        return productMapper.selectById(productId);
    }
}
