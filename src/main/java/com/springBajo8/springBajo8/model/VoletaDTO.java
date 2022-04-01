package com.springBajo8.springBajo8.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "volantes")
public class VoletaDTO {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 3);
    private String nombreProveedor;
    private List<ProductoDTO> productos;
    private int idProveedor;

    public VoletaDTO(){};

    public VoletaDTO(String nombreProveedor, List<ProductoDTO> productos, int idProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.productos = productos;
        this.idProveedor = idProveedor;
    }

    public VoletaDTO(String id, String nombreProveedor, List<ProductoDTO> productos, int idProveedor) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.productos = productos;
        this.idProveedor = idProveedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "VoletaDTO{" +
                "id='" + id + '\'' +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                ", productos=" + productos +
                ", idProveedor=" + idProveedor +
                '}';
    }
}
