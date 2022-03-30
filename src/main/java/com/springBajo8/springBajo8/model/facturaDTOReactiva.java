package com.springBajo8.springBajo8.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "facturas")
public class facturaDTOReactiva {

    @Id
    private String Id = UUID.randomUUID().toString().substring(0, 10);
    //private Date fecha;
    private String nombreCliente;
    private String empleadoQueAtendio;
    //private List<productoDTO> comprados;
    private int precioTotal;

    public String getId() {
        return Id;
    }

    /*public Date getFecha() {
        return fecha;
    }*/

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEmpleadoQueAtendio() {
        return empleadoQueAtendio;
    }

    /*public List<productoDTO> getComprados() {
        return comprados;
    }*/

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setId(String id) {
        Id = id;
    }

    /*public void setFecha(Date fecha) {
        this.fecha = fecha;
    }*/

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setEmpleadoQueAtendio(String empleadoQueAtendio) {
        this.empleadoQueAtendio = empleadoQueAtendio;
    }

    /*public void setComprados(List<productoDTO> comprados) {
        this.comprados = comprados;
    }*/

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    /*@Override
    public String toString() {
        return "facturaDTOReactiva{" +
                "Id='" + Id + '\'' +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", empleadoQueAtendio='" + empleadoQueAtendio + '\'' +
                ", comprados=" + comprados +
                ", precioTotal=" + precioTotal +
                '}';
    }*/
}
