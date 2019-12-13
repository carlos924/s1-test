package com.example.shipmentapi.Repository;

import com.example.shipmentapi.model.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

  @Query("from Shipment where trackingnumber=:trackingnumber")
  public Shipment findByTrakingnumber(@Param("trackingnumber")String trackingNumber);
}
