package com.springBajo8.springBajo8.controller;

import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.model.VolanteDTO;
import com.springBajo8.springBajo8.service.FacturaService;
import com.springBajo8.springBajo8.service.VolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class VolanteController {

    @Autowired
    private VolanteService volanteService;

    @PostMapping("/volantes")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<VolanteDTO> save(@RequestBody VolanteDTO volanteDTO) {
        return this.volanteService.save(volanteDTO);
    }

    @DeleteMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolanteDTO>> delete(@PathVariable("id") String id) {
        return this.volanteService.delete(id)
                .flatMap(volanteDTO -> Mono.just(ResponseEntity.ok(volanteDTO)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolanteDTO>> update(@PathVariable("id") String id, @RequestBody VolanteDTO volanteDTO) {
        return this.volanteService.update(id, volanteDTO)
                .flatMap(volanteDTO1 -> Mono.just(ResponseEntity.ok(volanteDTO1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @GetMapping(value = "/volantes")
    private Flux<VolanteDTO> findAllVolantes() {
        return this.volanteService.findAll();
    }

}
