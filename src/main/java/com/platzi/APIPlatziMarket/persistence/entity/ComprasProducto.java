package com.platzi.APIPlatziMarket.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
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

    //Relaciones entre Tablas

    /*
     * Relacion CompraProductos-Compra,
     * (Muchas CompraProductos pueden ser Una Compra);
     * M:1
     *
     * @ManyToOne -> indica relacion Muchos a uno
     * @JoinColumn(
     *       name ="llaveForanea",
     *       insertable= fase --> para que no se pueda insertar una nueva categoria desde produtos
     *       updatable = fase --> para que nos se pueda Actualizar la tabla categoria desde producto
     * )
     *
     * private Compra compra -->Este atributo indicara relacion con la clase compra
     */
    @ManyToOne
    @JoinColumn(name="id_compra", insertable = false, updatable= false)
    private Compra compra;

    /*
     * Relacion CompraProductos-Producto,
     * (Muchas CompraProductos pueden ser Un Produco);
     * M:1
     *
     * @ManyToOne -> indica relacion Muchos a uno
     * @JoinColumn(
     *       name ="llaveForanea",
     *       insertable= fase --> para que no se pueda insertar una nueva categoria desde produtos
     *       updatable = fase --> para que nos se pueda Actualizar la tabla categoria desde producto
     * )
     *
     * private Producto pruducto -->Este atributo indicara relacion con la clase producto
     */
    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false)
    private Producto producto;



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
