package com.example.sprdemo.service;

import cn.hutool.core.date.DateUtil;
import com.example.sprdemo.mapper.UserMapper;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.model.User;
import com.example.sprdemo.util.TokenUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
  @Resource
  UserMapper userMapper;

  public User selectByUsername(String username) {
    User paramUser = new User();
    paramUser.setUsername(username);
    List<User> users = userMapper.selectAll(paramUser);
    if (users.size() > 0) {
      return users.get(0);
    }
    return null;
  }

  public User selectByTel(String tel) {
    User paramUser = new User();
    paramUser.setTel(tel);
    List<User> users = userMapper.selectAll(paramUser);
    if (users.size() > 0) {
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

  public Result update(User user) {
    User currentUser = null;
    try {
      currentUser = TokenUtils.getCurrentUser();
    } catch (Exception e) {
      return Result.error("403", "请重新登录");
    }
    if (currentUser == null) {
      return Result.error("403", "用户未登录");
    }

    if(user.getUsername() != null){
      User user1 = new User();
      user1.setUsername(user.getUsername());
      List<User> users = userMapper.IgnoreCurentUserUsernameSelectAll(user.getUsername(),currentUser.getId());
      if(users.size() > 0){
        return Result.error("403", "用户名已存在");
      }
    }
  //使用的
    if(user.getTel() != null){
      User user1 = new User();
      user1.setTel(user.getTel());
      List<User> users = userMapper.IgnoreCurentUserTelSelectAll(user.getTel(), currentUser.getId());
      if(users.size() > 0){
        return Result.error("403", "每个手机号只能绑定一个账号");
      }
    }

    if(user.getEmail() != null){
      User user1 = new User();
      user1.setTel(user.getEmail());
      List<User> users = userMapper.IgnoreCurentUserEmialSelectAll(user.getEmail(), currentUser.getId());
      if(users.size() > 0){
        return Result.error("403", "手机号已存在");
      }
    }

    user.setId(currentUser.getId());
    int update = userMapper.update(user);

    if (update == 0) {
      return Result.error("500", "更新失败");
    }
    return Result.success();
  }


  public Result login(User user) {
    List<User> users = userMapper.selectAll(user);
    if (users.size() > 0) {
      String token = TokenUtils.createToken(users.get(0).getId() + "");
      users.get(0).setAuthorization(token);
      return Result.success(users.get(0));
    } else {
      return Result.error("403", "用户名或密码错误");
    }
  }

  /**
   * 充值
   *
   * @param money
   * @return
   */
  public Result recharge(BigDecimal money) {
    int i = userMapper.updateBalance(TokenUtils.getCurrentUser().getId(), money.add(TokenUtils.getCurrentUser().getBalance()));
    return Result.success();
  }
}
