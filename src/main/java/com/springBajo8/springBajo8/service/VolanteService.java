package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.model.VolanteDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VolanteService {
    Mono<VolanteDTO> save(VolanteDTO volanteDTO);

    Mono<VolanteDTO> delete(String id);

    Mono<VolanteDTO> update(String id, VolanteDTO volanteDTO);

    Flux<VolanteDTO> findAll();

    Mono<VolanteDTO> findById(String id);
}
