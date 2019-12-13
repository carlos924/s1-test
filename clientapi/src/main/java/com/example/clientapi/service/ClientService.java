package com.example.clientapi.service;

import com.example.clientapi.model.ClientWithShipment;

public interface ClientService {
    public ClientWithShipment getShipment(String trackingnumber);

    public ClientWithShipment addShipment(String username, String trackingnumber);
}
