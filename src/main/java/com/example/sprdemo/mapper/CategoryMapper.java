package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Category;

import java.util.List;

public interface CategoryMapper {
  List<Category> selectAll(Category category);

  int insert(Category category);


  void updateById(Category category);

  Category selectByCode(String code);

  Category selectByName(String name);
}
