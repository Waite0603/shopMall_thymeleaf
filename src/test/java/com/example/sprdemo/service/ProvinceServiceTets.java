package com.example.sprdemo.service;


import com.example.sprdemo.model.Province;
import com.example.sprdemo.model.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProvinceServiceTets {


  @Resource
  private ProvinceService provinceService;

  @Test
  public void testGetAllAreas() {
    Result<List<Province>> listResult = provinceService.selectAllAreas();
    System.out.println(listResult);

  }
}
