package com.dds.notesbox.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class JWTAuthenticationFilter {

  @Autowired
  AuthenticationManager authManager;

  

  //@Override
  public String attemptAuthentication(AuthCredentials authCredentials) throws AuthenticationException {


    UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
      authCredentials.getEmail(), 
      authCredentials.getPassword(),
      Collections.emptyList()
      );

    System.out.println(">>>>>>>>>>>>>>> " + usernamePAT);
    try {
      UserDetailsImpl userDetails = (UserDetailsImpl) authManager.authenticate(usernamePAT).getPrincipal();
      //TODO: Ir a successful
      System.out.println(">>>>>>>>>>" + userDetails.getName() + " : " + userDetails.getUsername());
      return JWTUtils.createToken(userDetails.getName(), userDetails.getUsername());
    } 
    catch (BadCredentialsException bce) {
      System.out.println("Bad credentials :(");
      bce.printStackTrace();
      throw bce;
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }

  }

  // //@Override
  // protected String successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
  //         Authentication authResult) throws IOException, ServletException {
      
  //     UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
  //     String token = JWTUtils.createToken(userDetails.getName(), userDetails.getUsername());

  //     //response.addHeader("Authorization", "Bearer " + token);
  //     //response.getWriter().flush();

  //     return token;

  // }
}
