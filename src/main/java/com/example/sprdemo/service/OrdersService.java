package com.example.sprdemo.service;

import com.example.sprdemo.mapper.OrdersMapper;
import com.example.sprdemo.model.GoodsDao;
import com.example.sprdemo.model.Orders;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.model.User;
import com.example.sprdemo.util.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

  @Resource
  private OrdersMapper ordersMapper;

  @Resource GoodsService goodsService;


  /**
   * 获取登录用户的订单详情
   * @return
   */
  public Result getCurrentUserOrders() {
    User currentUser = TokenUtils.getCurrentUser();
    List<Orders> oreders = ordersMapper.getCurrentUserOrders(currentUser.getId());
    for ( Orders o:oreders) {
      List<GoodsDao> goodsDaoList = goodsService.selectByOrdersId(o.getId());
      o.setGoodsList(goodsDaoList);
    }
    return Result.success(oreders);
  }


}
