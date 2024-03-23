package com.example.sprdemo.controller;


import com.example.sprdemo.model.Province;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.ProvinceService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreasController {


  @Resource
  private ProvinceService provinceService;

  @GetMapping("/getAllAreas")
  public ResponseEntity<Result> getAllArea() {

    Result result = provinceService.selectAllAreas();

    return ResponseEntity.ok(result);
  }
}
