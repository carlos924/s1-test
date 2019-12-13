package com.example.clientapi.service;

import com.example.clientapi.model.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  public String signup(Client client);

  public String login(Client client);
}
