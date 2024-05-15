package com.example.sprdemo.model;

import lombok.Data;

@Data
public class Category {

  private Integer id;
  private String code;
  private String aname;
  private Integer pid;
  private String isShow;

}
