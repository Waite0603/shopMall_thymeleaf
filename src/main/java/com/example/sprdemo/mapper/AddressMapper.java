package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Address;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface AddressMapper {

  void insert(Address address);

  List<Address> selectAll(Address address);

  @Delete("delete from address where id = #{id}")
  int deleteById(int id);

  int update(Address address);
}
