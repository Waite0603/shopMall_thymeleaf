package com.example.sprdemo.service;

import cn.hutool.core.date.DateUtil;
import com.example.sprdemo.mapper.UserMapper;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.model.User;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Resource
  UserMapper userMapper;

  public User selectByUsername(String username) {
    User paramUser = new User();
    paramUser.setUsername(username);
    List<User> users = userMapper.selectAll(paramUser);
    if (!users.isEmpty()) {
      return users.get(0);
    }
    return null;
  }

  public User selectByTel(String tel) {
    User paramUser = new User();
    paramUser.setTel(tel);
    List<User> users = userMapper.selectAll(paramUser);
    if (!users.isEmpty()) {
      return users.get(0);
    }
    return null;
  }



  public List<User> selectAll(User user) {
    return userMapper.selectAll(user);
  }


  /**
   * 注册时的手机号与用户名均不能重复
   *
   * @param user
   * @return
   */
  public Result register(User user) {
    if (this.selectByUsername(user.getUsername()) != null) {
      return Result.error("403", "用户名已存在");
    }
    if (this.selectByTel(user.getTel()) != null) {
      return Result.error("403", "手机号已存在");
    }
    User paramUser = new User();
    paramUser.setUsername(user.getUsername());
    paramUser.setPassword(user.getPassword());
    paramUser.setTel(user.getTel());
    paramUser.setRegTime(DateUtil.now());
    int insert = userMapper.insert(paramUser);
    if (insert > 0) {
      return Result.success();
    } else {
      return Result.error("500", "注册失败");
    }

  }

  public Result update(User user, HttpServletRequest request) {
    User SessionUser = (User) request.getSession().getAttribute("user");
    if (SessionUser == null) {
      return Result.error("403", "用户未登录");
    }
    if (user.getId() != SessionUser.getId()) {
      return Result.error("403", "不允许更改其它用户的信息");
    }
    int update = userMapper.update(user);
    if (update == 0) {
      return Result.error("500", "更新失败");
    }
    return Result.success();
  }


  public Result login(User user, HttpServletRequest request) {
    List<User> users = userMapper.selectAll(user);
    if (!users.isEmpty()) {
      request.getSession().setAttribute("user", users.get(0));
      return Result.success(users.get(0));
    } else {
      return Result.error("403", "用户名或密码错误");
    }
  }

}
