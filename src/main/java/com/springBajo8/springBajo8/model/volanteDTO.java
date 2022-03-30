package com.springBajo8.springBajo8.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "volantes")
public class volanteDTO {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String nombreProveedor;
    private List<productoDTO> productos;
    private int idProveedor;
}
