package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.model.VolanteDTO;
import com.springBajo8.springBajo8.repository.VolanteRepository;
import com.springBajo8.springBajo8.service.VolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteServiceImpl implements VolanteService {

    @Autowired
    @Qualifier("volante")
    private VolanteRepository volanteRepository;

    @Override
    public Mono<VolanteDTO> save(VolanteDTO volanteDTO) {
        return this.volanteRepository.save(volanteDTO);
    }

    @Override
    public Mono<VolanteDTO> delete(String id) {
        return this.volanteRepository
                .findById(id)
                .flatMap(p -> this.volanteRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<VolanteDTO> update(String id, VolanteDTO volanteDTO) {
        return this.volanteRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    volanteDTO.setId(id);
                    return save(volanteDTO);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<VolanteDTO> findAll() {
        return this.volanteRepository.findAll();
    }

    @Override
    public Mono<VolanteDTO> findById(String id) {
        return this.volanteRepository.findById(id);
    }
}
