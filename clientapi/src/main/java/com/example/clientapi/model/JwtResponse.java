package com.example.clientapi.model;

public class JwtResponse {

  private String jwt;

  private String username;

  public JwtResponse(String username, String jwt) {
    this.jwt = jwt;
    this.username = username;
  }

  public String getToken() {
    return this.jwt;
  }

  public String getUsername() {
    return this.username;
  }
}