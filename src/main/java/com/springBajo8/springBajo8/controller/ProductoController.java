package com.springBajo8.springBajo8.controller;

import com.springBajo8.springBajo8.model.ProductoDTO;
import com.springBajo8.springBajo8.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProductoDTO> save(@RequestBody ProductoDTO productoDTO) {
        return this.productoService.save(productoDTO);
    }

    @DeleteMapping("/productos/{id}")
    private Mono<ResponseEntity<ProductoDTO>> delete(@PathVariable("id") String id) {
        return this.productoService.delete(id)
                .flatMap(productoDTO -> Mono.just(ResponseEntity.ok(productoDTO)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/productos/{id}")
    private Mono<ResponseEntity<ProductoDTO>> update(@PathVariable("id") String id, @RequestBody ProductoDTO productoDTO) {
        return this.productoService.update(id, productoDTO)
                .flatMap(productoDTO1 -> Mono.just(ResponseEntity.ok(productoDTO1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @GetMapping(value = "/productos")
    private Flux<ProductoDTO> findAllVolantes() {
        return this.productoService.findAll();
    }

}
