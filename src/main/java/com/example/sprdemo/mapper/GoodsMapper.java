package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Goods;

import java.util.List;

public interface GoodsMapper {
  List<Goods> selectAllGoods(Goods goods);
}
