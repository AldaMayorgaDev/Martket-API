package com.platzi.APIPlatziMarket.persistence.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_compra")
    private Integer idCompra;

    @Column(name= "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name= "medio_pago")
    private Character medioPago;

    private String comentario;

    private Character estado;



    //Relaciones entre Tablas

    /*
     * Relacion Compra-Cliente,
     * (Muchas Compras pueden pertenecer a Un Cliente);
     * M:1
     *
     * @ManyToOne -> indica relacion Muchos a uno
     * @JoinColumn(
     *       name ="llaveForanea",
     *       insertable= fase --> para que no se pueda insertar una nueva categoria desde produtos
     *       updatable = fase --> para que nos se pueda Actualizar la tabla categoria desde producto
     * )
     *
     * private Cliente cliente -->Este atributo indicara relacion con la clase Cliente
     */
    @ManyToOne
    @JoinColumn(name="id_cliente", insertable = false, updatable = false)
    private Cliente cliente;


    /*
     * Relacion Compra-ComprasProducto,
     * (Una Compra puede tener Muchas ComprasProducto );
     * 1:M
     *
     * @OneToMany(mappedBy = "AtributoQueInidcaRelacionEnLaOtraClase") -> indica relacion Uno a Muchos
     * private List<ComprasProducto> productos; --> Es una lista de ComprasProductos
     */
    @OneToMany(mappedBy = "compra")
    private List<ComprasProducto> productos;


    //Getters & Setters

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Character getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(Character medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
}
