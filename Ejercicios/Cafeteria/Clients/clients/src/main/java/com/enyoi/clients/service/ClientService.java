package com.enyoi.clients.service;

import com.enyoi.clients.dto.SaveNewClientDto;
import com.enyoi.clients.model.Client;
import com.enyoi.clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client saveNewClient(SaveNewClientDto dto){

        Client client = mapDtoToClient(dto);

        return repository.save(client);
    }

    public Client getClientEmail(String email){
        return repository.findByEmail(email);
    }


    private Client mapDtoToClient(SaveNewClientDto dto){

        Client client = new Client();
        client.setEmail(dto.getEmail());
        client.setNombre(dto.getName());

        return client;
    }
}
