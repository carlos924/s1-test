package com.example.shipmentapi.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.shipmentapi.Service.ShipmentService;
import com.example.shipmentapi.model.Shipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShipmentController.class})
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ShipmentControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @InjectMocks
  private Shipment shipment;

  @MockBean
  private ShipmentService shipmentService;

  @Before
  public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    shipment.setId(1L);
    shipment.setTrackingNumber("111");
  }

  @Test
  public void getShipment_Shipment_Success() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/111");

    when(shipmentService.getShipment(anyString())).thenReturn(shipment);

    MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
        .andExpect(content().json("{\"id\":1,\"trackingNumber\":\"111\"}")).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }
}
