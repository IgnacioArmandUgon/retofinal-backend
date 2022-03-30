package com.springBajo8.springBajo8.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "facturas")
public class productoDTO {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombreProducto;

    private int Precio;
}
