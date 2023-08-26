package com.platzi.APIPlatziMarket.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="compras_productos")
public class ComprasProducto {

    //Atributos

    /*
    * Llave primaria computas, es decir la columna id_compra y id_producto generan una PK
    * Por lo tanto es necesario crear una clase que sera embebida (ComprasProductoPK)
    * esa clase contendra la pk y ya solo en cesario agregar @EmbeddedId
    * */

    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    //Getters and Setters


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
