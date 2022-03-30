package com.springBajo8.springBajo8.controller;


import com.springBajo8.springBajo8.model.facturaDTOReactiva;
import com.springBajo8.springBajo8.service.facturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class facturasController {

    @Autowired
    private facturaService facturaService;

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<facturaDTOReactiva> save(@RequestBody facturaDTOReactiva citasDTOReactiva) {
        return this.facturaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/facturas/{id}")
    private Mono<ResponseEntity<facturaDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.facturaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/facturas/{id}")
    private Mono<ResponseEntity<facturaDTOReactiva>> update(@PathVariable("id") String id, @RequestBody facturaDTOReactiva citasDTOReactiva) {
        return this.facturaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @GetMapping(value = "/")
    private Flux<facturaDTOReactiva> findAll() {
        return this.facturaService.findAll();
    }

}
