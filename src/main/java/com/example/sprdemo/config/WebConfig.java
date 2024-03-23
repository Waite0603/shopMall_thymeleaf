package com.example.sprdemo.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Resource
  private JwtIntercepter jwtInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/")
        //登录注册api
        .excludePathPatterns("/api/user/login")
        .excludePathPatterns("/api/user/register")
        //静态资源
        .excludePathPatterns("/js/**")
        .excludePathPatterns("/images/**")
        .excludePathPatterns("/css/**")
        .excludePathPatterns("/files/**")
        //页面
        .excludePathPatterns("/login")
        .excludePathPatterns("/register")
        .excludePathPatterns("/goods/detail")
        .excludePathPatterns("/shoppingCart")
        .excludePathPatterns("/centerInfo")
        .excludePathPatterns("/centerPassword")
        .excludePathPatterns("/centerAvatar")
        .excludePathPatterns("/centerAddress")
        .excludePathPatterns("/centerOrders")
        .excludePathPatterns("/manageType")
        .excludePathPatterns("/manageMerchant")
        .excludePathPatterns("/manageStore")
        .excludePathPatterns("/error")
    ;
  }
}
