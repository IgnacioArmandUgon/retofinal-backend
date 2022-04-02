package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.model.ProductoDTO;
import com.springBajo8.springBajo8.repository.ProductoRepository;
import com.springBajo8.springBajo8.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    @Qualifier("producto")
    private ProductoRepository productoRepository;

    @Override
    public Mono<ProductoDTO> save(ProductoDTO productoDTO) {
        return this.productoRepository.save(productoDTO);
    }

    @Override
    public Mono<ProductoDTO> delete(String id) {
        return this.productoRepository
                .findById(id)
                .flatMap(p -> this.productoRepository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<ProductoDTO> update(String id, ProductoDTO productoDTO) {
        return this.productoRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    productoDTO.setId(id);
                    return save(productoDTO);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<ProductoDTO> findAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Mono<ProductoDTO> findById(String id) {
        return this.productoRepository.findById(id);
    }
}
