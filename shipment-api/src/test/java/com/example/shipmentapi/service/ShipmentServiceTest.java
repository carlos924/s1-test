package com.example.shipmentapi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.shipmentapi.Repository.ShipmentRepository;
import com.example.shipmentapi.Service.ShipmentServiceImpl;
import com.example.shipmentapi.model.Shipment;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ShipmentServiceTest {
  @Rule
  public MockitoRule rule = MockitoJUnit.rule().silent();

  @InjectMocks
  private ShipmentServiceImpl shipmentService;

  @InjectMocks
  private Shipment shipment;

  @Mock
  private ShipmentRepository shipmentRepository;

  @Before
  public void init(){
    shipment.setId(1L);
    shipment.setTrackingNumber("111");
  }

  @Test
  public void getShipment_Shipment_Success(){

    when(shipmentRepository.findByTrakingnumber(anyString())).thenReturn(shipment);

    Shipment actualShipment = shipmentService.getShipment("111");
    assertEquals("111", actualShipment.getTrackingNumber());
  }
}
