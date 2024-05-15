package com.example.sprdemo.mapper;

import com.example.sprdemo.model.User;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface UserMapper {

    int updateBalance(int id, BigDecimal money);

    List<User> selectAll(User user);

  int insert(User user);

  int update(User user);

  @Select("select * from customer where tel = #{username} and id not in (#{id})")
  List<User> IgnoreCurentUserUsernameSelectAll(String username, int id);


  @Select("select * from customer where tel = #{tel} and id not in (#{id})")
  List<User> IgnoreCurentUserTelSelectAll(String tel, int id);


  @Select("select * from customer where email = #{email} and id not in (#{id})")
  List<User> IgnoreCurentUserEmialSelectAll(String email, int id);
}
