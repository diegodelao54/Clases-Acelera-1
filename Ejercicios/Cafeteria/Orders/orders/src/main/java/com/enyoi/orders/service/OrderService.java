package com.enyoi.orders.service;

import com.enyoi.orders.dto.ClientResponseDto;
import com.enyoi.orders.dto.CreateNewOrderCreatingNewClientDto;
import com.enyoi.orders.dto.GenerateNewOrderDto;
import com.enyoi.orders.model.Order;
import com.enyoi.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${clientApi}")
    private String endPoint;

    public Order createNewOrder(GenerateNewOrderDto dto){

        ResponseEntity<ClientResponseDto> responseDto;


        System.out.println("Imprimir la variable definida en properties : " + endPoint);
        String url = "localhost:8081/api/v1/client/"+dto.getClientEmail();

        // RestTemplate.exchage()
        //1. cual es la URL
        //2. cual es el verbo
        //3. cual es el contenido a enviar?
        //3. cuales don los headers que vas a enviar
        //4. cual es la respuesta esperada

        responseDto = this.restTemplate.exchange(url, HttpMethod.GET, null, ClientResponseDto.class);

        // verificando la respuesta
        if(responseDto.getStatusCode().is2xxSuccessful()){
            ClientResponseDto bodyResponse = responseDto.getBody();
            //creando orden
            Order order = new Order();
            order.setClientId(bodyResponse.getId());

            return repository.save(order);
        }
        throw new RuntimeException("Error") ;
    }

    //Metodo para crear un cliente nuevo con su nueva orden
    public Order creatingNewOrderCreatingNewClient(CreateNewOrderCreatingNewClientDto dto){

        String url = "localhost:8081/api/v1/client";

        HttpEntity<CreateNewOrderCreatingNewClientDto> request = new HttpEntity<>(dto);

        ResponseEntity<ClientResponseDto> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, ClientResponseDto.class);

        ClientResponseDto bodyResponse = responseEntity.getBody();

        Order order = new Order();

        order.setClientId(bodyResponse.getId());

        return repository.save(order);
    }

}
