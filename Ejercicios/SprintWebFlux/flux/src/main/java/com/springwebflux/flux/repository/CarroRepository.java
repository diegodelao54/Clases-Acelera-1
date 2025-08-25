package com.springwebflux.flux.repository;

import com.springwebflux.flux.entity.Carro;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CarroRepository extends R2dbcRepository<Carro, Integer> {

    Flux<Carro> findByPersonaId(Integer personaId);
}
