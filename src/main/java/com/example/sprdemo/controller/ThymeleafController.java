package com.example.sprdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @GetMapping("/goods/detail")
  public String detail() {
    return "detail";
  }

  @GetMapping("/shoppingCart")
  public String shoppingCart() {
    return "shoppingCart";
  }

  @GetMapping("/centerInfo")
  public String centerInfo() {
    return "center/centerInfo";
  }

  @GetMapping("/centerPassword")
  public String passwordManagement() {
    return "center/centerPassword";
  }

  @GetMapping("/centerAvatar")
  public String centerAvatar() {
    return "center/centerAvatar";
  }

  @GetMapping("/centerAddress")
  public String centerAddress() {
    return "center/centerAddress";
  }

  @GetMapping("/centerOrders")
  public String centerOrders() {
    return "center/centerOrders";
  }

  @GetMapping("/manageType")
  public String manageType() {
    return "manage/manageType";
  }

  @GetMapping("/manageMerchant")
  public String manageMerchant() {
    return "manage/manageMerchant";
  }

  @GetMapping("/manageStore")
  public String manageStore() {
    return "manage/manageStore";
  }
}