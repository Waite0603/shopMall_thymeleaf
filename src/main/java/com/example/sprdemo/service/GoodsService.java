package com.example.sprdemo.service;

import com.example.sprdemo.mapper.GoodsMapper;
import com.example.sprdemo.model.Goods;
import com.example.sprdemo.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
  @Resource
  private GoodsMapper goodsMapper;
  public Result getAllGoods(Goods goods, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Goods> goodsList = goodsMapper.selectAllGoods(goods);
    PageInfo<Goods> goodsPageInfo = PageInfo.of(goodsList);
    return Result.success(goodsPageInfo);
  }
}
