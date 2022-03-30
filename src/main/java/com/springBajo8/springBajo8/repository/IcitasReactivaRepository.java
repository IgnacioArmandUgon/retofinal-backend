package com.springBajo8.springBajo8.repository;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.facturaDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IcitasReactivaRepository extends ReactiveMongoRepository<facturaDTOReactiva, String> {
    Flux<facturaDTOReactiva> findByIdPaciente(String idPaciente);
}
