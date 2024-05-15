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
    public ResponseEntity<Result> getCategory(Category category,
                                              @RequestParam(defaultValue = "1") int pageNum,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        Result result = categotyService.selectPage(category, pageNum, pageSize);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Result> addCategory(@RequestBody Category category) {
        Result result = categotyService.addCategory(category);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateCategory")
    public ResponseEntity updateCategory(@RequestBody Category category) {
        if (category == null || category.getId() == 0) {
            return ResponseEntity.ok(Result.error("403", "请求参数错误"));
        }
        Result result = categotyService.ModifyById(category);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/checkCodeRepeated")
    public ResponseEntity checkCodeRepeated(@RequestParam("code") String code) {
        if(code == null){
            return ResponseEntity.ok(Result.error("403","请求参数异常"));
        }
        Result result = categotyService.checkCodeRepeated(code);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/checkNameRepeated")
    public ResponseEntity checkNameRepeated(@RequestParam("name") String name) {
        if(name == null){
            return ResponseEntity.ok(Result.error("403","请求参数异常"));
        }
        Result result = categotyService.checkNameRepeated(name);
        return ResponseEntity.ok(result);
    }


}
