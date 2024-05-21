package com.example.sprdemo.model;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class Product {

    private Integer id;
    private String dname;
    private String code;
    private String intro;
    private String detail;
    private String categoryId;
    private String brandId;
}
