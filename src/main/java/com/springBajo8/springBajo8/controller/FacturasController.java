package com.springBajo8.springBajo8.controller;


import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class FacturasController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturaDTO> save(@RequestBody FacturaDTO facturaDTO) {
        return this.facturaService.save(facturaDTO);
    }

    @DeleteMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturaDTO>> delete(@PathVariable("id") String id) {
        return this.facturaService.delete(id)
                .flatMap(facturaDTO -> Mono.just(ResponseEntity.ok(facturaDTO)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturaDTO>> update(@PathVariable("id") String id, @RequestBody FacturaDTO facturaDTO) {
        return this.facturaService.update(id, facturaDTO)
                .flatMap(facturaDTO1 -> Mono.just(ResponseEntity.ok(facturaDTO1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @GetMapping(value = "/")
    private Flux<FacturaDTO> findAll() {
        return this.facturaService.findAll();
    }

}
