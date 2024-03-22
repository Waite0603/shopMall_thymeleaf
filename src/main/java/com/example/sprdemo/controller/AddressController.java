package com.example.sprdemo.controller;

import com.example.sprdemo.model.Address;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Address address) {
        if(address.getProvinceId() == 0 || address.getCityId() == 0 ||
            address.getRegionId() == 0 || address.getDetail() == null ){
            return ResponseEntity.ok(Result.error("403", "请补充完整地址信息"));
        }
        Result result = addressService.insert(address);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    @RequestMapping("/selectAll")
    public ResponseEntity<Result> selectAll() {
        Result result = addressService.selectAll();
        return ResponseEntity.ok(result);
    }



}
