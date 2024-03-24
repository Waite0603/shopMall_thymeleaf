package com.example.sprdemo.mapper;


import com.example.sprdemo.model.Orders;

import java.util.List;

public interface OrdersMapper {
  List<Orders> getCurrentUserOrders(int id);
}
