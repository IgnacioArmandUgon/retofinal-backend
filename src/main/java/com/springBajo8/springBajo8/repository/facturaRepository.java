package com.springBajo8.springBajo8.repository;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.model.facturaDTOReactiva;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@Qualifier("factura")
public interface facturaRepository extends ReactiveMongoRepository<facturaDTOReactiva, String> {
    Mono<facturaDTOReactiva> findById(String id);
}
