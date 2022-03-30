package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.model.facturaDTOReactiva;
import com.springBajo8.springBajo8.repository.facturaRepository;
import com.springBajo8.springBajo8.service.facturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class facturaServiceImpl implements facturaService {

    @Autowired
    @Qualifier("factura")
    private facturaRepository facturaRepository;

    @Override
    public Mono<facturaDTOReactiva> save(facturaDTOReactiva facturaDTOReactiva) {
        return this.facturaRepository.save(facturaDTOReactiva);
    }

    @Override
    public Mono<facturaDTOReactiva> delete(String id) {
        return this.facturaRepository
                .findById(id)
                .flatMap(p -> this.facturaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<facturaDTOReactiva> update(String id, facturaDTOReactiva facturaDTOReactiva) {
        return this.facturaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    facturaDTOReactiva.setId(id);
                    return save(facturaDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<facturaDTOReactiva> findAll() {
        return this.facturaRepository.findAll();
    }

    @Override
    public Mono<facturaDTOReactiva> findById(String id) {
        return this.facturaRepository.findById(id);
    }
}
