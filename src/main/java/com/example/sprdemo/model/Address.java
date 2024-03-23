package com.example.sprdemo.model;

import lombok.Data;

@Data
public class Address {
  private int id;
  private int provinceId;
  private int cityId;
  private int regionId;
  private String provinceName;
  private String cityName;
  private String regionName;
  private int customerId;
  private String detail;
}
