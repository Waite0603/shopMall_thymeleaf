package com.example.sprdemo.controller;

import com.example.sprdemo.model.Result;
import com.example.sprdemo.model.User;
import com.example.sprdemo.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Resource
  private UserService userService;

  @RequestMapping("/login")
  public ResponseEntity<Result> login(@RequestBody User user, HttpServletRequest request) {
    if (user.getUsername() == null || user.getPassword() == null) {
      return ResponseEntity.ok(Result.error("403", "用户名或密码不能为空"));
    }
    Result result = userService.login(user, request);
    return ResponseEntity.ok(result);
  }

  @RequestMapping("/logout")
  public ResponseEntity<Result> logout(HttpServletRequest request) {
    request.getSession().removeAttribute("user");
    return ResponseEntity.ok(Result.success("退出成功"));
  }

  @PostMapping("/register")
  public ResponseEntity<Result> register(@RequestBody User user) {
    if (user.getUsername() == null || user.getPassword() == null || user.getTel() == null) {
      return ResponseEntity.ok(Result.error("403", "用户名、密码、手机号不能为空"));
    }
    Result result = userService.register(user);
    return ResponseEntity.ok(result);
  }
  @PostMapping("/update")
  public ResponseEntity<Result> update(@RequestBody User user , HttpServletRequest request){
    if (user.getId() == 0) {
      return ResponseEntity.ok(Result.error("403", "用户ID不能为空"));
    }
    Result result = userService.update(user, request);
    return ResponseEntity.ok(result);
  }

}
