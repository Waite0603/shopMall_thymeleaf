package com.example.sprdemo.controller;

import com.example.sprdemo.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {
  @GetMapping("/")
  public ModelAndView index(HttpServletRequest request) {
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
      return new ModelAndView("login");
    }
    return new ModelAndView("index", "user", user);
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