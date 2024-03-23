package com.example.sprdemo.config;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtIntercepter implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String requestURL = request.getRequestURL().toString();
    String authorization = request.getHeader("Authorization");
    if(ObjectUtil.isEmpty(authorization)) {
      authorization = request.getParameter("Authorization");
    }
    if(ObjectUtil.isEmpty(authorization)) {
      returnJson(response, "请先登录",401);
      return false;
    }
    return true;
  }

  private void returnJson(HttpServletResponse response, String message,int code) throws Exception{
    PrintWriter writer = null;
    // 注意点1：这边返回配置为josn格式
    response.setContentType("application/json;charset=UTF-8");
    try {
      Map<String, Object> result = new HashMap<>();
      result.put("code", code);
      result.put("msg", message);
      writer = response.getWriter();
      // 注意点2，这样要用fastjson转换一下后，返回的前端才是格式化后的json格式
      writer.print(JSON.toJSONString(result));
    } catch (IOException e) {
    } finally {
      if (writer != null)
        writer.close();
    }
  }

}
