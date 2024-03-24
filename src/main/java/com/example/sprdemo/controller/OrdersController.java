package com.example.sprdemo.controller;

import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {


  @Resource
  private OrdersService ordersService;

  @GetMapping("/getCurrentUserOrders")
  public ResponseEntity<Result> getCurrentUserOrders() {

    Result result = ordersService.getCurrentUserOrders();

    return ResponseEntity.ok(result);
  }



}
