package com.example.sprdemo.service;

import com.example.sprdemo.mapper.CategoryMapper;
import com.example.sprdemo.model.Category;
import com.example.sprdemo.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategotyService {

  @Resource
  CategoryMapper categoryMapper;

  public Result selectPage(Category category, int pageNum, int pagesize) {
    PageHelper.startPage(pageNum, pagesize);
    List<Category> categories = categoryMapper.selectAll(category);
    PageInfo<Category> categoryPageInfo = PageInfo.of(categories);
    return Result.success(categoryPageInfo);
  }


  /**
   * 查询所有分类
   * @param category category中name按模糊查询
   * @return
   */
  public List<Category> selectAll(Category category) {
    return categoryMapper.selectAll(category);
  }
}
