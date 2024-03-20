package com.example.sprdemo.controller;

import com.example.sprdemo.model.Result;
import com.example.sprdemo.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserController {
  @RequestMapping("/login")
  public ResponseEntity<Result> login(User user, HttpServletRequest request) {
    request.getSession().setAttribute("user", user);

    if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
      Map<String, String> userRes = Map.of("username", user.getUsername());
      return ResponseEntity.ok(Result.success(userRes));
    }
    else {
      return ResponseEntity.status(403).body(Result.error("403", "账号或者密码错误"));
    }
  }

  @RequestMapping("/logout")
  public ResponseEntity<String> logout(HttpServletRequest request) {
    request.getSession().removeAttribute("user");
    return ResponseEntity.ok("redirect:/");
  }
}