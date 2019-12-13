package com.example.clientapi.repository;

import com.example.clientapi.model.Shipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="shipment")
public interface ShipmentRepository {

    @GetMapping("/{trackingnumber}")
    public Shipment getShipment(@PathVariable String trackingnumber);

    @PostMapping("/addshipment")
    public Shipment addShipment(@RequestBody Shipment newShipment);

    @GetMapping("/getClientId/{id}")
    public Long getClientIdByShipmentId(@PathVariable Long id);

    @PostMapping("/{clientid}/{shipmentid}")
    public void addClientIdToShipmentId(@PathVariable Long clientid, @PathVariable Long shipmentid);
}
