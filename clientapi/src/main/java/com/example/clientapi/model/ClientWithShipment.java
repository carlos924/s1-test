package com.example.clientapi.model;

import java.util.List;

public class ClientWithShipment {
    private Long clientId;
    private String name;
    private Shipment shipment;

    public ClientWithShipment(Client client, Shipment shipment) {
        this.clientId = client.getId();
        this.name = client.getName();
        this.shipment = shipment;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
