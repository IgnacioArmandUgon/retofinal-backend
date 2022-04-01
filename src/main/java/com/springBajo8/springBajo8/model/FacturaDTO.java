package com.springBajo8.springBajo8.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "facturas")
public class FacturaDTO {

    @Id
    private String id;

    private String nombreCliente;
    private String empleadoQueAtendio;
    private int precioTotal;
    private List<ProductoDTO> comprados;
    private Date fecha;
    public Date getFecha() {
        return fecha;
    }

    public FacturaDTO(String id, String nombreCliente, String empleadoQueAtendio, int precioTotal) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.empleadoQueAtendio = empleadoQueAtendio;
        this.precioTotal = precioTotal;
    }

    public String getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEmpleadoQueAtendio() {
        return empleadoQueAtendio;
    }

    public List<ProductoDTO> getComprados() {
        return comprados;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setId(String id) {
        id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setEmpleadoQueAtendio(String empleadoQueAtendio) {
        this.empleadoQueAtendio = empleadoQueAtendio;
    }

    public void setComprados(List<ProductoDTO> comprados) {
        this.comprados = comprados;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "facturaDTOReactiva{" +
                "Id='" + id + '\'' +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", empleadoQueAtendio='" + empleadoQueAtendio + '\'' +
                ", comprados=" + comprados +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
