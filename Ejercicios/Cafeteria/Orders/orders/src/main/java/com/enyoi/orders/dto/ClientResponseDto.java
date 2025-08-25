package com.enyoi.orders.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true) //cualquier campo que no reconozca que lo ignore
public class ClientResponseDto {

    private String id;

//    @JsonProperty("email")//en el json este campo se llama email
//    private String mail; //pero para mi, por comodidad lo llamo mail


}
