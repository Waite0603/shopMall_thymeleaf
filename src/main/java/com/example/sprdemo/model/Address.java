package com.example.sprdemo.model;

import lombok.Data;

@Data
public class Address {
  private int id;
  private int provinceId;
  private int cityId;
  private int regionId;
  private int customerId;
  private String detail;
}
