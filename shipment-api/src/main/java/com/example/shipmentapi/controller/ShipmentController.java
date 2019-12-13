package com.example.shipmentapi.controller;

import com.example.shipmentapi.Service.ShipmentService;
import com.example.shipmentapi.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/shipment/{trackingnumber}")
    public Shipment getShipment(@PathVariable String trackingnumber) {
        return shipmentService.getShipment(trackingnumber);
    }

    @PostMapping("/shipment/addshipment")
    public Shipment addShipment(@RequestBody Shipment shipment) {
        return shipmentService.addShipment(shipment);
    }

    @GetMapping("/getClientId/{id}")
    public Long getClientIdByShipmentId(@PathVariable Long id){

    }

    @PostMapping("/{clientid}/{shipmentid}")
    public void addClientIdToShipmentId(Long clientid, Long shipmentid){

    }

}
