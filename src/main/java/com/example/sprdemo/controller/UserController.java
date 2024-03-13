package com.example.sprdemo.controller;

import com.example.sprdemo.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {
  @RequestMapping("/login")
  public String login(User user, HttpServletRequest request) {
    request.getSession().setAttribute("user", user);
    // 输出
    System.out.println("user: " + user);
    System.out.println("user.getUsername(): " + user.getUsername());

    // 密码校验
    if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
      return "redirect:/";
    }
    else {
      // 弹出提示
      return "redirect:/login";
    }
  }

  @RequestMapping("/logout")
  public String logout(HttpServletRequest request) {
    request.getSession().removeAttribute("user");
    return "redirect:/";
  }
}
