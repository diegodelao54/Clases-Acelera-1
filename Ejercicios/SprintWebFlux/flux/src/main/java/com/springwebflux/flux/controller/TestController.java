package com.springwebflux.flux.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> test(){
        return Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(1));
    }


    @PostMapping(value = "/flux-input", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> testInputFlux(@RequestBody Flux<Integer> emitidorDeNumeros){
        return emitidorDeNumeros.map(n -> n*2).doOnComplete(() -> System.out.println("Completo"));
    }




}
