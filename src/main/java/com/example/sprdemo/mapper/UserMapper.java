package com.example.sprdemo.mapper;

import com.example.sprdemo.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

  List<User> selectAll(User user);

  int insert(User user);

  int update(User user);
}
