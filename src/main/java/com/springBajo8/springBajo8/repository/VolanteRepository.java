package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.model.VolanteDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@Qualifier("volante")
public interface VolanteRepository extends ReactiveMongoRepository<VolanteDTO, String> {
    Mono<VolanteDTO> findById(String id);
}
