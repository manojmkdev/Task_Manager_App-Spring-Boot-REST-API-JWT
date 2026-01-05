
package com.example.taskmanager.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilter {

 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
  throws IOException, ServletException {

  HttpServletRequest req = (HttpServletRequest) request;
  String auth = req.getHeader("Authorization");

  if (auth != null && auth.startsWith("Bearer ")) {
   String token = auth.substring(7);
   String username = JwtUtil.extractUsername(token);
   SecurityContextHolder.getContext().setAuthentication(
    new UsernamePasswordAuthenticationToken(username, null, null)
   );
  }
  chain.doFilter(request, response);
 }
}
