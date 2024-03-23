package com.example.sprdemo.service;


import com.example.sprdemo.model.City;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CityServiceTest {


  @Resource
  private CityService cityService;

  @Test
  public void testSelectCityByProvinceId() {
    City city = new City();
    city.setProvId(10000);
    List<City> cities = cityService.selectAllCity(city);
    System.out.println(cities);
  }

}
