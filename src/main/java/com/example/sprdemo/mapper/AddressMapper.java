package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Address;

import java.util.List;

public interface AddressMapper {

  void insert(Address address);

  List<Address> selectAll(Address address);
}
