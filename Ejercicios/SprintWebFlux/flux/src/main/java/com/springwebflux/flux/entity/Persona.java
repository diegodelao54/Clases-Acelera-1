package com.springwebflux.flux.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("PERSONAS")
@Setter
@Getter
@ToString
public class Persona {

    @Id
    private Integer id;

    private String nombre;

    private Integer edad;

//    @MappedCollection(idColumn = "persona_id")
//    private List<Carro> carros;
}
