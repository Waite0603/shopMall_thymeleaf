package com.example.sprdemo.mapper;

import com.example.sprdemo.model.Goods;
import com.example.sprdemo.model.GoodsDao;
import com.example.sprdemo.model.Orders;

import java.util.List;

public interface GoodsMapper {
    List<Goods> selectAllGoods(Goods goods);

    List<GoodsDao> selectByOrdersId(Integer orderId);

    void insertGoods(Goods goods);

    Integer deleteGoodsById(Integer id);

    Integer updateById(Goods goods);

    Orders selectOrdersByGoodsId(Integer id);

    Goods selectGoodsByCode(String code);
}
