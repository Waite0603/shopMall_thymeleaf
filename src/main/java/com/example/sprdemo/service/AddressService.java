package com.example.sprdemo.service;

import com.example.sprdemo.mapper.AddressMapper;
import com.example.sprdemo.model.Address;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.model.User;
import com.example.sprdemo.util.TokenUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {





  @Resource
  AddressMapper addressMapper;
  public Result insert(Address address) {
    User currentUser = TokenUtils.getCurrentUser();
    address.setCustomerId(currentUser.getId());
    addressMapper.insert(address);
    return Result.success();
  }

  public Result selectAll() {
    User currentUser = TokenUtils.getCurrentUser();
    Address address = new Address();
    address.setCustomerId(currentUser.getId());
    List<Address> addressList = addressMapper.selectAll(address);
    return Result.success(addressList);
  }
}
