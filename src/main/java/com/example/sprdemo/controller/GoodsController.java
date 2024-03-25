package com.example.sprdemo.controller;

import com.example.sprdemo.model.Goods;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

  @Resource
  private GoodsService goodsService;

  @GetMapping("/getAllGoods")
  public ResponseEntity<Result> getAllGoods(Goods goods,
                                            @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize) {
    Result result = goodsService.getAllGoods(goods,pageNum,pageSize);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/getGoodsById")
  public ResponseEntity<Result> getGoodsById(Goods goods) {
    Result result = goodsService.getGoodsById(goods.getId());
    return ResponseEntity.ok(result);
  }

}
