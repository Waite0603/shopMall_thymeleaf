package com.example.sprdemo.service;

import com.example.sprdemo.mapper.AddressMapper;
import com.example.sprdemo.model.Address;
import com.example.sprdemo.model.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

  @Resource
  AddressMapper addressMapper;
  public Result insert(Address address) {
    addressMapper.insert(address);
    return Result.success();
  }

  public Result selectAll() {
    List<Address> addressList = addressMapper.selectAll();
    return Result.success(addressList);
  }
}
