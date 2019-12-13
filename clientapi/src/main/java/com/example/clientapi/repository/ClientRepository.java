package com.example.clientapi.repository;

import com.example.clientapi.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByName(String name);
}
