package com.enyoi.clients.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class Client {

    @Id
    private String id;
    private String Nombre;
    private String email;

}
