package com.example.clientapi.service;

import com.example.clientapi.model.Client;
import com.example.clientapi.model.ClientWithShipment;
import com.example.clientapi.model.Shipment;
import com.example.clientapi.repository.ClientRepository;
import com.example.clientapi.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ShipmentRepository shipmentRepository;


    @Override
    public ClientWithShipment getShipment(String trackingnumber) {
        Shipment shipment = shipmentRepository.getShipment(trackingnumber);
        Long clientId = shipmentRepository.getClientIdByShipmentId(shipment.getId());
        Client client = clientRepository.findById(clientId).orElse(null);
        return new ClientWithShipment(client, shipment);
    }

    @Override
    public ClientWithShipment addShipment(String username, String trackingnumber) {
        Client client = clientRepository.findByName(username);
        if (client == null) {
            client = new Client();
            client.setName(username);
            client = clientRepository.save(client);
        }
        Shipment newShipment = new Shipment();
        newShipment.setTrackingNumber(trackingnumber);
        Shipment shipment = shipmentRepository.addShipment(newShipment);
        shipmentRepository.addClientIdToShipmentId(client.getId(), shipment.getId());

        return new ClientWithShipment(client, shipment);
    }

}
