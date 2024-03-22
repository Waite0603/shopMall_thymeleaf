package com.example.sprdemo.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "customer")
public class User {
  private int id	;
  private String realname;
  private String username;
  private String password;
  private String imgUrl;
  private String intro;
  private String tel;
  private String email;
  private String gender;
  private String cardID;
  private String regTime;
  private String state;
  private String level ;
  private int addressId;
  private String Authorization;
}
