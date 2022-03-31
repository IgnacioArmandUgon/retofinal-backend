package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.model.FacturaDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@Qualifier("factura")
public interface FacturaRepository extends ReactiveMongoRepository<FacturaDTO, String> {
    Mono<FacturaDTO> findById(String id);
}
