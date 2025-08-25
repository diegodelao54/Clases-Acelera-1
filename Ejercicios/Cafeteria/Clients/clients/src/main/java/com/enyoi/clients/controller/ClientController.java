package com.enyoi.clients.controller;

import com.enyoi.clients.dto.SaveNewClientDto;
import com.enyoi.clients.model.Client;
import com.enyoi.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody SaveNewClientDto dto){

        Client response = service.saveNewClient(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getClient(@PathVariable("email") String email){

        Client response = service.getClientEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
