package com.example.shipmentapi.Service;

import com.example.shipmentapi.Repository.ShipmentRepository;
import com.example.shipmentapi.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService{

  @Autowired
  private ShipmentRepository shipmentRepository;

  @Override
  public Shipment getShipment(String trackingNumber) {
    return shipmentRepository.findByTrakingnumber(trackingNumber);
  }

  @Override
  public Shipment addShipment(Shipment shipment) {
    return shipmentRepository.save(shipment);
  }
}
