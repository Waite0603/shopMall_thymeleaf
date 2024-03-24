package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Goods;
import com.example.sprdemo.model.GoodsDao;

import java.util.List;

public interface GoodsMapper {
  List<Goods> selectAllGoods(Goods goods);

  List<GoodsDao> selectByOrdersId(Integer orderId);
}
