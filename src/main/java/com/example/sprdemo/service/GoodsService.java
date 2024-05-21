package com.example.sprdemo.service;

import com.example.sprdemo.mapper.GoodsMapper;
import com.example.sprdemo.model.Goods;
import com.example.sprdemo.model.GoodsDao;
import com.example.sprdemo.model.Orders;
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

  public List<GoodsDao> selectByOrdersId(Integer orderId) {
    return goodsMapper.selectByOrdersId(orderId);

  }

  public Result getGoodsById(Integer id) {
    Goods goods = new Goods();
    goods.setId(id);
    List<Goods> g = goodsMapper.selectAllGoods(goods);
    return Result.success(g.get(0));
  }

  public Result addGoods(Goods goods) {
    Goods dbGoods = goodsMapper.selectGoodsByCode(goods.getCode());
    if (dbGoods != null){
      return Result.error("403","商品编码已存在");
    }
    goodsMapper.insertGoods(goods);

    return Result.success();
  }

  public Result removeById(Integer id) {
    Orders orders = goodsMapper.selectOrdersByGoodsId(id);
    //如果商品下尚有订单则不允许删除
    if (orders != null){
      return Result.error("403","商品下尚有订单，不允许删除");
    }
    //如果没有则直接删除
    goodsMapper.deleteGoodsById(id);
    return Result.success();
  }

  /**
   * 新增或者修改 主要看id有无值
   * @param goods
   * @return
   */
  public Result updateOrAdd(Goods goods) {
    if(goods == null || goods.getId() == null ||  goods.getId() == 0){
        goodsMapper.insertGoods(goods);
        return Result.success("新增成功");
    }else {
      Integer i = goodsMapper.updateById(goods);
      if (i == 0){
        return Result.error("403","商品不存在");
      }
      return Result.success("修改成功");
    }

  }
}
