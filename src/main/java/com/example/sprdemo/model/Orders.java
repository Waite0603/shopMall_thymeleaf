package com.example.sprdemo.model;


import lombok.Data;

import java.util.List;

@Data
public class Orders {


  private Integer id;
  private String code;//流水号
  private Double totalSum;//总金额
  private Double carriage;//邮费
  private Double realSum;//实付金额
  private Double totalNum;//总数量
  private String receiverAddress;//收货地址
  private String receiverName;//收件人姓名
  private String receiverTel;//收件人电话
  private String state;//0未支付 1已支付 2已发货 3已收货
  private String orderTime;//下单时间
  private String payTime;//支付时间
  private int customerId;//订单所属的客户id
  private String payType;//支付方式


  private List<GoodsDao> goodsList;
}
