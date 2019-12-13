package com.example.clientapi.controller;

import com.example.clientapi.model.ClientWithShipment;
import com.example.clientapi.model.Input;
import com.example.clientapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clientfe/shipment/{trackingnumber}")
    public ClientWithShipment getShipment(@PathVariable String trackingnumber) {
        return clientService.getShipment(trackingnumber);
    }

    @PostMapping("/clientfe/addshipment")
    public ClientWithShipment addShipment(@RequestBody Input input) {
        return clientService.addShipment(input.getName(), input.getTrackingNumber());
    }
}
