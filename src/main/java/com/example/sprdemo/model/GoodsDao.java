package com.example.sprdemo.model;


/**订单包含的商品信息
 *
 */

import lombok.Data;

@Data
public class GoodsDao {
  private int id;
  private String keywords;
  private String code;
  private String spec;
  private String chSpec;
  private Double inPrice;
  private Double outPrice;
  private int stock;
  private String imgUrl;
  private int productId;
  private String productName;//商品名称
  private String described;//商品描述

  private Double buyPrice;//购买价格
  private int buyNum;//购买数量
}
