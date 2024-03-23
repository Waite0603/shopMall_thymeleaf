package com.example.sprdemo.controller;

import com.example.sprdemo.model.Address;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.AddressService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody Address address) {
        Result result = addressService.delete(address);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Address address) {
        Result result = addressService.update(address);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/selectAll")
    public ResponseEntity<Result> selectAll() {
        Result result = addressService.selectAll();
        return ResponseEntity.ok(result);
    }



}
