package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.repository.FacturaRepository;
import com.springBajo8.springBajo8.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    @Qualifier("factura")
    private FacturaRepository facturaRepository;

    @Override
    public Mono<FacturaDTO> save(FacturaDTO facturaDTO) {
        return this.facturaRepository.save(facturaDTO);
    }

    @Override
    public Mono<FacturaDTO> delete(String id) {
        return this.facturaRepository
                .findById(id)
                .flatMap(p -> this.facturaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<FacturaDTO> update(String id, FacturaDTO facturaDTO) {
        return this.facturaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    facturaDTO.setId(id);
                    return save(facturaDTO);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<FacturaDTO> findAll() {
        return this.facturaRepository.findAll();
    }

    @Override
    public Mono<FacturaDTO> findById(String id) {
        return this.facturaRepository.findById(id);
    }
}
