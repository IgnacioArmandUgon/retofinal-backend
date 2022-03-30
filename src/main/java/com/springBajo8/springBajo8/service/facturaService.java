package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.model.facturaDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface facturaService {
    Mono<facturaDTOReactiva> save(facturaDTOReactiva facturaDTOReactiva);

    Mono<facturaDTOReactiva> delete(String id);

    Mono<facturaDTOReactiva> update(String id, facturaDTOReactiva facturaDTOReactiva);

    Flux<facturaDTOReactiva> findAll();

    Mono<facturaDTOReactiva> findById(String id);
}
