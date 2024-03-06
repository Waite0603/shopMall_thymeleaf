package com.example.sprdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
  @GetMapping("/")
  public String index(Model model) {
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
}