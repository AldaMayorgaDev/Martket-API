package com.platzi.APIPlatziMarket.persistence.entity;
import javax.persistence.*;

@Entity
@Table(name= "productos")
public class Producto {

    //Atributos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_producto")
    private Integer idProducto;

    private String nombre;

    @Column (name="id_categoria")
    private Integer idCategoria;

    @Column (name="codigo_barras")
    private String codigoBarras;

    @Column (name="precio_venta")
    private Double precioVenta;

    @Column (name="cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    //Relaciones entre Tablas

    /*
    * Relacion Producto-Categoria,
    * (Muchos productos pueden tener una categoria);
    * M:1
    *
    * @ManyToOne -> indica relacion Muchos a uno
    * @JoinColumn(
    *       name ="llaveForanea",
    *       insertable= fase --> para que no se pueda insertar una nueva categoria desde produtos
    *       updatable = fase --> para que nos se pueda Actualizar la tabla categoria desde producto
    * )
    *
    * private Categoria categoria -->Este atributo indicara relacion con la clase categoria
    */
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    //Getters & Setters


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
