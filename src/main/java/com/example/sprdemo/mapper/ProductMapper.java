package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {


    Product selectById(@Param("id") int productId);
}
