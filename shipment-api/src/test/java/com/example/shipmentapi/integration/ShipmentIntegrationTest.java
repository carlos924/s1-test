package com.example.shipmentapi.integration;

import static org.junit.Assert.assertEquals;

import com.example.shipmentapi.Repository.ShipmentRepository;
import com.example.shipmentapi.model.Shipment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableAutoConfiguration(exclude = {RabbitAutoConfiguration.class})
@DirtiesContext
public class ShipmentIntegrationTest {

  @Autowired
  private ShipmentRepository shipmentRepository;

  @InjectMocks
  private Shipment shipment;

  @Before
  public void init() {
    shipment.setId(1L);
    shipment.setTrackingNumber("111");
    shipmentRepository.save(shipment);
  }

  @Test
  public void findShipmentById_Success() {
    Shipment shipment = shipmentRepository.findById(1L).orElse(null);
    assertEquals("111", shipment.getTrackingNumber());
  }

  @Test
  public void findShipmentByTrackingNumber_Success() {
    Shipment shipment = shipmentRepository.findByTrakingnumber("111");
    assertEquals("111", shipment.getTrackingNumber());
    assertEquals(1l, (long) shipment.getId());
  }
}
