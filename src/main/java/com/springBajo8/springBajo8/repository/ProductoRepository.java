package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.model.ProductoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@Qualifier("producto")
public interface ProductoRepository extends ReactiveMongoRepository<ProductoDTO, String> {
    Mono<ProductoDTO> findById(String id);
}
