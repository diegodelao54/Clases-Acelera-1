package com.arca.clients.service;

import com.arca.clients.entity.Clients;
import com.arca.clients.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientsService {

    private final ClientsRepository repository;

    //obtener todos los clientes
    public Flux<Clients> getAllClients(){
        return repository.findAll();
    }

    //obtener el cliente segun unico
    public Mono<Clients> getClient(String unique)
    {
        return repository.findByUnique(unique);
    }

    //Guardar Clientes
    public Flux<Clients> saveClient(Flux<Clients> clientsFlux)
    {
        System.out.println("cliente a guardar: " + clientsFlux);
        return repository.saveAll(clientsFlux);
    }

}
