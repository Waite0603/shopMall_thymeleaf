package com.example.sprdemo.service;

import com.example.sprdemo.mapper.CategoryMapper;
import com.example.sprdemo.model.Category;
import com.example.sprdemo.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategotyService {

  @Resource
  CategoryMapper categoryMapper;

  public  Result ModifyById(Category category) {
    try {
      categoryMapper.updateById(category);
      return Result.success();
    }catch (Exception e){
      e.printStackTrace();
      return Result.error("403","请求失败请检查分类名或者分类代码是否已存在");
    }

  }

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

  public Result addCategory(Category category) {
    int flag  = categoryMapper.insert(category);
    if(flag == 0) {
      return Result.error("403","记录已经存在，添加失败");
    }
    return Result.success();
  }


  public Result checkCodeRepeated(String code) {
    final String CHECK_KEY = "codeIsRepeated";
    Category category = categoryMapper.selectByCode(code);
    Map<String,Boolean> map = new HashMap<>();
    if(category == null){
      map.put(CHECK_KEY,false);
    }else {
      map.put(CHECK_KEY,true);
    }
    return Result.success(map);
  }

  public Result checkNameRepeated(String name) {
    final String CHECK_KEY = "nameIsRepeated";
    Category category = categoryMapper.selectByName(name);
    Map<String,Boolean> map = new HashMap<>();
    if(category == null){
      map.put(CHECK_KEY,false);
    }else {
      map.put(CHECK_KEY,true);
    }
    return Result.success(map);
  }
}
