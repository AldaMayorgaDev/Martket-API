package com.platzi.APIPlatziMarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//Se pone @Embeddable por que es una clase que se añadira dentro a la clase ComprasProducto
//Es necesario implementar la interface Serializable
@Embeddable
public class ComprasProductoPK implements Serializable {

    //Atributos que componen la PK compuesta
    @Column(name= "id_compra")
    private Integer idCompra;

    @Column(name= "id_producto")
    private Integer idProducto;

    //Getters Y Setters


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
