package com.example.sprdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class Province {
  private int id;
  private String ename;
  List<City> cities;
}
