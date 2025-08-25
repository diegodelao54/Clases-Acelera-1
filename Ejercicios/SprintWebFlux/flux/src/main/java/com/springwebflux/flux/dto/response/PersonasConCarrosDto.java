package com.springwebflux.flux.dto.response;

import com.springwebflux.flux.entity.Carro;
import com.springwebflux.flux.entity.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PersonasConCarrosDto {

    private Persona persona;
    private List<Carro> carros;

}
