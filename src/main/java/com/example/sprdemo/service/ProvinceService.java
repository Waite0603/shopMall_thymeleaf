package com.example.sprdemo.service;

import com.example.sprdemo.mapper.ProvinceMapper;
import com.example.sprdemo.model.City;
import com.example.sprdemo.model.Province;
import com.example.sprdemo.model.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

  @Resource
  private ProvinceMapper provinceMapper;

  @Resource
  CityService cityService;

  public Result<List<Province>> selectAllAreas() {
    List<Province> provinces = provinceMapper.selectAllProvince();
    for (Province province : provinces) {
      List<City> cities = cityService.selectCityByProvinceId(province.getId());
      province.setCities(cities);
    }
    return Result.success(provinces);
  }
}
