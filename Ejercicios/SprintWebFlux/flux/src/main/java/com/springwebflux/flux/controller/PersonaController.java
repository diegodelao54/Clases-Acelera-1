package com.springwebflux.flux.controller;

import com.springwebflux.flux.entity.Persona;
import com.springwebflux.flux.service.PersonasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

    private final PersonasService service;

    public PersonaController(PersonasService service) {
        this.service = service;
    }

    @PostMapping(value = "/savePersona", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Persona> savePersona(@RequestBody Persona personas){
        System.out.println("Datos de entrada: " + personas);
        return service.savePersona(personas);
    }

    @PostMapping(value = "/saveAllPersona", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Persona> saveAllPersona(@RequestBody Flux<Persona> personas){
        return service.saveAllPersona(personas);
    }

    @GetMapping(value = "/getEdadPersona/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Persona> getEdadPersona(@PathVariable("edad") Integer edad){
        return service.getPersonasByEdad(Mono.just(edad));
    }

    @PostMapping(value = "/getNombrePersona", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Persona> getNombrePersona(@RequestBody Flux<String> nombre){
        return service.getPersoasByNames(nombre);
    }


}
