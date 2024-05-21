package com.example.sprdemo.model;

import lombok.Data;

@Data
public class Goods {
  private Integer id;
  private String keywords;
  private String code;
  private String spec;
  private String chSpec;
  private Double inPrice;
  private Double outPrice;
  private int stock;
  private String imgUrl;
  private int productId;
}
