package com.arca.clients.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clients")
@Setter
@Getter
@ToString
public class Clients {

    //nombre de los campos de la BD
    private String unique;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private String address1;
    private String address2;

}
