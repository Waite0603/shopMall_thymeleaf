package com.example.sprdemo.controller;

import com.example.sprdemo.model.Goods;
import com.example.sprdemo.model.Product;
import com.example.sprdemo.model.Result;
import com.example.sprdemo.service.GoodsService;
import com.example.sprdemo.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

  @Resource
  private ProductService productService;
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

  /**
   * 添加商品
   * @param goods 商品信息
   * @return 添加结果
   */
  @PostMapping("/addGoods")
  public ResponseEntity<Result> addGoods(@RequestBody Goods goods) {
    Result result = goodsService.addGoods(goods);
    return ResponseEntity.ok(result);
  }

  /**
   * 根据商品id删除
   * @param id
   * @return
   */
  @GetMapping("/removeGoodsById")
  public ResponseEntity<Result> getGoodsById(Integer id) {
    Result result = goodsService.removeById(id);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/updateOrAdd")
  public ResponseEntity<Result> updateOrAdd(@RequestBody Goods goods) {
    if (goods.getProductId() == 0){
      return ResponseEntity.ok(Result.error("403", "所属产品ID不能为空"));
    }
    Product product = productService.getById(goods.getProductId());
    if (product == null){
        return ResponseEntity.ok(Result.error("404", "根据产品id查询到的所属商品不存在"));
    }
    Result result = goodsService.updateOrAdd(goods);
    return ResponseEntity.ok(result);
  }
}
