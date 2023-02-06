package com.dds.notesbox.security;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
//TODO Unify both utils
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
  //TODO: Fix injection
  //@Value("${security.jwt.secret}")
  private static String key = "NNhp6kNnsu";

  //@Value("${security.jwt.issuer}")
  private static String issuer = "Main";

  //@Value("${security.jwt.ttlMillis}")
  private static long ttlMillis = 10800000;

  public static String createToken(String name, String email) {
    System.out.println(">>>KEY>>> " + key);
    System.out.println(">>>issuer>>> " + issuer);
    System.out.println(">>>ttlMillis>>> " + ttlMillis);
    long expirationTime = ttlMillis * 1_000;
    Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

    Map<String, Object> extra = new HashMap<>();
    extra.put("name", name);

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    return Jwts.builder()
    .setSubject(email)
    .setExpiration(expirationDate)
    .addClaims(extra)
    .signWith(signatureAlgorithm, key)
    .compact();
  }

  public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
    try {
      Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJwt(token).getBody();
      String email = claims.getSubject();
  
      return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
    } catch (Exception e) {
      return null;
    }
  }
}
