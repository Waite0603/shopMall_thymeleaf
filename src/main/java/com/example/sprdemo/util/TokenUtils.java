package com.example.sprdemo.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.sprdemo.model.User;
import com.example.sprdemo.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

/**
 * Token工具类
 */
@Component
public class TokenUtils {

  private static final Logger log = LoggerFactory.getLogger(TokenUtils.class);

  private static final String key = "123456";

  @Resource
  UserService userService;

  private static UserService staticUserService;

  @PostConstruct
  public void setUserService() {
    staticUserService = userService;
  }

  /**
   * 生成token
   */
  public static String createToken(String data) {
    return JWT.create()
        .withAudience(String.valueOf(data))
        .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
        .sign(Algorithm.HMAC256("key"));
  }

  /**
   * 获取当前登录的用户信息
   */
  public static User getCurrentUser() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String token = request.getHeader("Authorization");
    if (ObjectUtil.isEmpty(token)) {
      token = request.getParameter("Authorization");
    }
    if (ObjectUtil.isEmpty(token)) {
      return null;
    }
    String userId = JWT.decode(token).getAudience().get(0);
    User user = new User();
    user.setId(Integer.parseInt(userId));
    return staticUserService.selectAll(user).get(0);

  }
}

