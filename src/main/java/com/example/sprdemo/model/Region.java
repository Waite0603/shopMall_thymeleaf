package com.example.sprdemo.model;


import lombok.Data;

@Data
public class Region {
  private int id;
  private String fname;
  private String postCode;
  private int cityId;
}
