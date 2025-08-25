package com.springwebflux.flux.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Carros")
@Getter
@Setter
public class Carro {

    @Id
    private Integer Id;
    private String Marca;

    @Column("persona_id")
    private Integer personaId;
}
