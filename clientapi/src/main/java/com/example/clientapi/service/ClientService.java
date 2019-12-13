package com.example.clientapi.service;

import com.example.clientapi.model.Client;
import com.example.clientapi.model.ClientWithShipment;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    public ClientWithShipment getShipment(String trackingnumber);

    public ClientWithShipment addShipment(String username, String trackingnumber);

}
