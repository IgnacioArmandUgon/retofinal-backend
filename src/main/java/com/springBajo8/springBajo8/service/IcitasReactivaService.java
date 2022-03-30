package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.facturaDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcitasReactivaService {
    Mono<facturaDTOReactiva> save(facturaDTOReactiva citasDTOReactiva);

    Mono<facturaDTOReactiva> delete(String id);

    Mono<facturaDTOReactiva> update(String id, facturaDTOReactiva citasDTOReactiva);

    Flux<facturaDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<facturaDTOReactiva> findAll();

    Mono<facturaDTOReactiva> findById(String id);
}
