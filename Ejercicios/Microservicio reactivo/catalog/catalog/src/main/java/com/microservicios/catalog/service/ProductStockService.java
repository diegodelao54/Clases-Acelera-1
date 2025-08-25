package com.microservicios.catalog.service;

import com.microservicios.catalog.dto.ProductInfoDto;
import com.microservicios.catalog.dto.ProductStockDto;
import com.microservicios.catalog.entity.ProductStock;
import com.microservicios.catalog.repository.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductStockService {

    private ProductStockRepository repository;

    private WebClient webClient = WebClient.create("http://localhost:8080");

    //1. Obtener los productos desde el repositorio con stock mayor o igual a cero ----> Flux<ProductStcok> [v]
    //1.5 Necesito obtener el id del productos
    //2. necesito consultar a ms products para obtener info ----> Flux<ProductinfoDto>
    //3. Necesito construir un Flux<ProductStockDto> con la informacion de los flujos anteriores.

//    public Flux<ProductStock> getCatalogoOfProductsWithStock(){
////        Flux<ProductStock> productStockFlux = repository.findBystockGreaterThanEqual(0);
////        return repository.findBystockGreaterThanEqual(0);
//
//
//
//
////        Flux<ProductInfoDto> productInfoDtoFlux= webClient.post().bodyValue(//mandar flux de string
////            filterProductStockGreaterTahtEqualZero.block();
////        )
//    }

    public Flux<ProductStockDto> getCatalogOfProductWithStock(){

        Flux<ProductStock> productStockFlux = repository.findAll();
        Flux<ProductStock> filterProductStockGreaterTahtEqualZero = productStockFlux.filter(productStock -> productStock.getStock() >= 0);

        //Tengo un Flux<ProductStock>  -> Flux<String>

        //cual es el id, stock
        Flux<String> idFlux = filterProductStockGreaterTahtEqualZero.flatMap( productStock ->
                Flux.just(productStock.getProductId())
        );

        //Cual es el id, nombre y descipcion
        Flux<ProductInfoDto> productInfoDtoFlux = webClient.post().bodyValue(idFlux).retrieve().bodyToFlux(ProductInfoDto.class);

        return Flux.just();

    }

    public Flux<ProductStockDto> getCatlogWithInfo(){
    return repository.findAll()
            .filter(productStock -> productStock.getStock() >= 0)
            .flatMap(productStock -> {
                Mono<ProductInfoDto> productInfoDtoMono = webClient.get().uri("/api/v1/product" + productStock.getProductId())
                        .retrieve().bodyToMono(ProductInfoDto.class);
                return productInfoDtoMono.flatMapMany(productInfoDto ->
                    Flux.just(mapResponse(productInfoDto, productStock))
                );
            });
    }

    private ProductStockDto mapResponse(ProductInfoDto productInfoDto, ProductStock productStock){
        ProductStockDto dto = new ProductStockDto();
        dto.setId(productInfoDto.getId());
        dto.setName(productInfoDto.getName());
        dto.setDescription(productInfoDto.getDescription());
        dto.setStock(productStock.getStock());

        return dto;
    }


}
