package com.example.shipmentapi.Service;

import com.example.shipmentapi.Repository.ShipmentRepository;
import com.example.shipmentapi.Repository.UserShipmentRepository;
import com.example.shipmentapi.model.Shipment;
import com.example.shipmentapi.model.UserShipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService{

  @Autowired
  private ShipmentRepository shipmentRepository;

  @Autowired
  private UserShipmentRepository userShipmentRepository;

  @Override
  public Shipment getShipment(String trackingNumber) {
    return shipmentRepository.findByTrakingnumber(trackingNumber);
  }

  @Override
  public Shipment addShipment(Shipment shipment) {
    return shipmentRepository.save(shipment);
  }

  @Override
  public Long getClientIdByShipmentId(Long id) {
    UserShipment userShipment = userShipmentRepository.findById(id).orElse(null);
    return userShipment.getClientId();
  }

  @Override
  public void addClientIdToShipmentId(Long clientid, Long shipmentid) {
    UserShipment userShipment = new UserShipment();
    userShipment.setClientId(clientid);
    userShipment.setShipmentId(shipmentid);
    userShipmentRepository.save(userShipment);
    return;
  }
}
