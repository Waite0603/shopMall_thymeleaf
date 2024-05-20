package com.example.sprdemo.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class TolenManager {

  public static String encode(String str) {



    return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").setSubject(str)
        .setIssuer("admin")
        .setExpiration(new Date(System.currentTimeMillis() + 60000))
        .claim("name", "admin")
        .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, "admin").compact()
        ;



  }

//  public static String decode(String token) {
//    JwtBuilder builder = Jwts.parser().setSigningKey("admin")
//
//}
}
