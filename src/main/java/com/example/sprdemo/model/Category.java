package com.example.sprdemo.model;

import lombok.Data;

@Data
public class Category {

  private int id;
  private String code;
  private String aname;
  private int pid;
  private String isShow;

}
