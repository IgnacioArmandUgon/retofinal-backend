package com.springBajo8.springBajo8;

import com.springBajo8.springBajo8.model.FacturaDTO;
import com.springBajo8.springBajo8.service.FacturaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FacturasControllerTest {
    @Autowired
    private FacturaService facturaService;

    /*@Test
    @DisplayName("Get factura by id");
    void getCitaById() {
        FacturaDTO cita = new FacturaDTO("k13", "3", "Kike", 3);
        Mono<FacturaDTO> find = facturaService.findById("k13");
        StepVerifier.create(find).expectNext(cita);
    }*/
}

