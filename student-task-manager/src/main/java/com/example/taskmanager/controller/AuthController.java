
package com.example.taskmanager.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.dto.LoginRequest;
import com.example.taskmanager.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

 private final UserRepository repo;
 private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

 public AuthController(UserRepository repo) {
  this.repo = repo;
 }

 @PostMapping("/register")
 public String register(@RequestBody User user) {
  user.setPassword(encoder.encode(user.getPassword()));
  user.setRole("ROLE_USER");
  repo.save(user);
  return "User Registered Successfully";
 }

 @PostMapping("/login")
 public String login(@RequestBody LoginRequest req) {
  User user = repo.findByUsername(req.getUsername()).orElseThrow();
  if (encoder.matches(req.getPassword(), user.getPassword())) {
   return JwtUtil.generateToken(user.getUsername());
  }
  throw new RuntimeException("Invalid Credentials");
 }
}
