package com.springwebflux.flux.repository;

import com.springwebflux.flux.entity.Persona;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveCrudRepository<Persona, Integer> {

    //publicador de edad
    Flux<Persona> findByEdad(Mono<Integer> edad);

    Flux<Persona> findByNombre(Mono<String> nombres);
}
