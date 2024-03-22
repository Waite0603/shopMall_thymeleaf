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
      .excludePathPatterns("/api/user/login")
      .excludePathPatterns("/api/user/register")
      .excludePathPatterns("/files/**");
  }
}
