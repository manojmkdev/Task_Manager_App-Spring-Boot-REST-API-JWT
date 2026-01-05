
package com.example.taskmanager.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import javax.crypto.SecretKey;

public class JwtUtil {
 private static final String SECRET = "manoj-secret-key-for-the-encrypt";

 private static final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

 public static String generateToken(String username) {
  return Jwts.builder()
   .setSubject(username)
   .setIssuedAt(new Date())
   .setExpiration(new Date(System.currentTimeMillis() + 3600000))
   .signWith(key, SignatureAlgorithm.HS256)
   .compact();
 }

 public static String extractUsername(String token) {
  return Jwts.parserBuilder().setSigningKey(key).build()
   .parseClaimsJws(token)
   .getBody().getSubject();
 }
}
