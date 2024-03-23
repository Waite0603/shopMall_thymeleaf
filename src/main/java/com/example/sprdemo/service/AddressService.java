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

  public Result delete(Address address) {
    int flag = addressMapper.deleteById(address.getId());
    if (flag == 0) {
      return Result.error("403", "删除失败");
    }
    return Result.success();
  }


  public Result update(Address address) {
    int flag = addressMapper.update(address);
    if (flag == 0) {
      return Result.error("403", "更新失败");
    }
    return Result.success();
  }
}
