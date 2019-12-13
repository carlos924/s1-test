package com.example.shipmentapi.Repository;

import com.example.shipmentapi.model.UserShipment;
import org.springframework.data.repository.CrudRepository;

public interface UserShipmentRepository extends CrudRepository<UserShipment, Long> {

}
