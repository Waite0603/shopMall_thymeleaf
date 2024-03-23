package com.example.sprdemo.controller;

import com.example.sprdemo.model.Category;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.CategotyService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

  @Resource
  CategotyService categotyService;

  @GetMapping("/getAllCategory")
  public ResponseEntity<Result> getCategory(@RequestBody Category category,
                                            @RequestParam(defaultValue ="1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize) {
    Result result = categotyService.selectPage(category,pageNum, pageSize);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/addCategory")
  public ResponseEntity<Result> addCategory(@RequestBody Category category) {
    Result result = categotyService.addCategory(category);
    return ResponseEntity.ok(result);
  }


}
