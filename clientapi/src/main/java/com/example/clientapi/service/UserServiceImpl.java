package com.example.clientapi.service;

import com.example.clientapi.config.JwtUtil;
import com.example.clientapi.model.Client;
import com.example.clientapi.repository.ClientRepository;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  @Qualifier("encoder")
  private PasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private JwtUtil jwtUtil;

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Client user = clientRepository.findByName(username);

    if (user == null) {
      logger.warn("request with username: " + username + " is not found");
      throw new UsernameNotFoundException("User null");
    }

    return new org.springframework.security.core.userdetails.User(user.getName(),
        bCryptPasswordEncoder.encode(user.getPassword()), true, true, true, true,
        new ArrayList<>());
  }

  @Override
  public String login(Client user){
    if (user.getName() == null || user.getName().length() == 0) {
      throw new RuntimeException("invalid email");
    }
    if (user.getPassword() == null || user.getPassword().length() == 0) {
      logger.error("password is missing or empty");
      throw new RuntimeException("invalid password");
    }
    Client newUser = clientRepository.findByName(user.getName());

    if (newUser != null && bCryptPasswordEncoder
        .matches(user.getPassword(), newUser.getPassword())) {
      UserDetails userDetails = loadUserByUsername(newUser.getName());
      return jwtUtil.generateToken(userDetails);
    }

    throw new RuntimeException("invalid email/password pair");
  }

  @Override
  public String signup(Client newUser) {
    String defaultRoleName = "ROLE_USER";

    newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

    if (clientRepository.findByName(newUser.getName()) != null) {
      logger.warn("username already exists: " + newUser.getName());
      throw new RuntimeException("username already exists");
    }
    if (clientRepository.findByName(newUser.getName()) != null) {
      logger.warn("username already exists: " + newUser.getName());
      throw new RuntimeException("email already exists");
    }
    Client createdUser = clientRepository.save(newUser);
    if (createdUser != null) {
      UserDetails userDetails = loadUserByUsername(newUser.getName());
      logger.info("user: " + newUser.getName() + ":" + newUser.getName()
          + " successfully created an account");
      return jwtUtil.generateToken(userDetails);
    }
    logger.warn("signup failed");
    throw new RuntimeException("signup failed");
  }

}