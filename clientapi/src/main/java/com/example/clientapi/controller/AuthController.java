package com.example.clientapi.controller;

import com.example.clientapi.model.Client;
import com.example.clientapi.model.JwtResponse;
import com.example.clientapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  @Autowired
  private UserService userService;

  @PostMapping("clientfe/signup")
  public ResponseEntity<?> signup(@RequestBody Client client){
    return ResponseEntity.ok(new JwtResponse(client.getName(), userService.signup(client)));
  }

  @PostMapping("clientfe/login")
  public ResponseEntity<?> login(@RequestBody Client client){
    return ResponseEntity.ok(new JwtResponse(client.getName(), userService.login(client)));
  }
}
