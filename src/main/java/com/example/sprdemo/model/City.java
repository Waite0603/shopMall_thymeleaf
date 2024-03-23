package com.example.sprdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class City {
  private int id	;
  private String bname	;
  private int provId;
  private List<Region> regions;
}
