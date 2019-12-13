package com.example.clientapi.repository;

import com.example.clientapi.model.Shipment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "shipment")
public interface ShipmentRepository {

    @GetMapping("/shipment/{trackingnumber}")
    public Shipment getShipment(@PathVariable String trackingnumber);

    @GetMapping("/getClientId/{id}")
    public Long getClientIdByShipmentId(@PathVariable Long id);

    @PostMapping("/shipment/addshipment")
    public Shipment addShipment(@RequestBody Shipment newShipment);

    @PostMapping("/{clientid}/{shipmentid}")
    public void addClientIdToShipmentId(Long clientid, Long shipmentid);
}
