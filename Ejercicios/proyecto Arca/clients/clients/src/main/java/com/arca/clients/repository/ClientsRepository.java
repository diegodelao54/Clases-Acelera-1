package com.arca.clients.repository;

import com.arca.clients.entity.Clients;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientsRepository extends ReactiveMongoRepository<Clients, String> {

    Mono<Clients> findByUnique(String unique);
}
