package com.platzi.APIPlatziMarket.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;
    private Boolean estado;


    //Relacion entre tablas

    /*
     * Relacion Categoria-Producto,
     * (Una categoria puede tener Muchos productos );
     * 1:M
     *
     * @OneToMany(mappedBy = "AtributoQueInidcaRelacionEnLaOtraClase") -> indica relacion Uno a Muchos
     * private List<Producto> productos; --> Es una lista de Productos
     */
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    //Getters y Setters

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
