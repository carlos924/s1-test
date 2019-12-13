package com.example.shipmentapi.Service;

import com.example.shipmentapi.model.Shipment;

public interface ShipmentService {
  public Shipment getShipment(String trackingNumber);
  public Shipment addShipment(Shipment shipment);
}
