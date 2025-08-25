package com.arca.clients.controller;

import com.arca.clients.entity.Clients;
import com.arca.clients.service.ClientsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import jakarta.validation.constraints.NotBlank;

@RequestMapping("/api/v1/clients")
@RestController
@RequiredArgsConstructor
public class ClientsController {

    private final ClientsService service;

    @GetMapping
    public Flux<Clients> getAllClients(){
        return service.getAllClients();
    }

    @GetMapping("/{unique}")
    public Mono<Clients> getClients(@PathVariable String unique)
    {
        System.out.println("id del cliente a buscar : " + unique);
        return service.getClient(unique).switchIfEmpty(Mono.error(new RuntimeException("Cliente no encontrado con unique : " + unique)));
    }

    @PostMapping(value = "/saveClient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Clients> saveClients(@RequestBody Flux<Clients> clientsFlux){
        return service.saveClient(clientsFlux);
    }


}
