package com.springBajo8.springBajo8.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "citas")
public class facturaDTOReactiva {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private Date fecha;
    private String nombreCliente;
    private String empleadoQueAtendio;
    private List<String> comprados;
    private int precioTotal;

}
