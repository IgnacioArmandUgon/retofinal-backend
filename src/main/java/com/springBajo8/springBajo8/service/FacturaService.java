package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.model.FacturaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FacturaService {
    Mono<FacturaDTO> save(FacturaDTO facturaDTO);

    Mono<FacturaDTO> delete(String id);

    Mono<FacturaDTO> update(String id, FacturaDTO facturaDTO);

    Flux<FacturaDTO> findAll();

    Mono<FacturaDTO> findById(String id);
}
