package com.example.sprdemo.mapper;

import com.example.sprdemo.model.City;

import java.util.List;

public interface CityMapper {

  List<City> selectAllCity(City city);
}
