package com.springwebflux.flux.service;

import com.springwebflux.flux.dto.response.PersonasConCarrosDto;
import com.springwebflux.flux.entity.Carro;
import com.springwebflux.flux.entity.Persona;
import com.springwebflux.flux.repository.CarroRepository;
import com.springwebflux.flux.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PersonasService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CarroRepository carroRepository;

    public Mono<Persona> savePersona(Persona persona){
        System.out.println("Datos en Service: " + persona);
        return personaRepository.save(persona);
    }

    public Flux<Persona> saveAllPersona(Flux<Persona> persona){

        return personaRepository.saveAll(persona);
    }

    public Flux<Persona> getPersonasByEdad(Mono<Integer> emisorDeEdad){
        return personaRepository.findByEdad(emisorDeEdad);
    }


    public Flux<Persona> getPersoasByNames(Flux<String> emisorDeNombre){
        return emisorDeNombre.flatMap(
                nombre -> personaRepository.findByNombre(Mono.just(nombre))
        );
    }

    //personaRepository ---> Obtener la persona por Id ----> Mono<Persona>
    //Obtener los carros de la persona ----> carroRepository.findByPersonaId ----> Flux<Carro>
    //A ese flux de carro, debo convertirlo en una lisgta y asignarlo a un DTO personaCarros
    public Mono<PersonasConCarrosDto> getPersonaConCarrosByIdPersona(Integer personaId)
    {
        return personaRepository.findById(personaId)
                .flatMap(//se usa flatMap para connvertir de Mono<persona> a PersonaConCarros
                        persona -> { // para esta persona, Que vamos a hacer? como hare para obtener el PersonaConCarros
                    Flux<Carro> carroFlux = carroRepository.findByPersonaId(persona.getId());// Obtengo el Flux de carros
                    Mono<List<Carro>> monoCarroList = carroFlux.collectList();// Ese Flux de carro lo convierto en un Mono<List>
                    return monoCarroList.flatMap( carroList -> //tomar este Mono<List<Carro>> y devolver un Mono<PersonaConCarros>
                        Mono.just(mapPersonaCarros(persona, carroList))
                    );
                });
    }


    private PersonasConCarrosDto mapPersonaCarros(Persona persona, List<Carro> carroList){
        PersonasConCarrosDto dto = new PersonasConCarrosDto();
        dto.setCarros(carroList);
        dto.setPersona(persona);
        return dto;
    }

}
