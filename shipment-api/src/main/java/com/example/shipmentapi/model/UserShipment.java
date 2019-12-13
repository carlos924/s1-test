package com.example.shipmentapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_shipment")
public class UserShipment {

  @Column(name = "client_id")
  private Long clientId;

  @Id
  @Column(name = "shipment_id")
  private Long shipmentId;

  public UserShipment() {

  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public Long getShipmentId() {
    return shipmentId;
  }

  public void setShipmentId(Long shipmentId) {
    this.shipmentId = shipmentId;
  }
}

