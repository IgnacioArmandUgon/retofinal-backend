package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.model.ProductoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    Mono<ProductoDTO> save(ProductoDTO productoDTO);

    Mono<ProductoDTO> delete(String id);

    Mono<ProductoDTO> update(String id, ProductoDTO productoDTO);

    Flux<ProductoDTO> findAll();

    Mono<ProductoDTO> findById(String id);
}
