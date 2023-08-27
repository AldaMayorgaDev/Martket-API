package com.platzi.APIPlatziMarket.persistence;

import com.platzi.APIPlatziMarket.persistence.crud.ProductoCrudRepository;
import com.platzi.APIPlatziMarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository //Con la anotacion Repository indicamos a Spring que esta clase se encarga de interactuar con la BD
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Metodo que Recupera todos los productos de la BD
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //Metodo que retorna una lista con todos los productos que pertenecen a una categoria especifica utlizando el QueryMethod creado

    public List<Producto> getByCategory(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    // Metodo que recupera todos los productos que su cantidad en stock son menores a (cantidad) y que su estado sea igual a true
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //Metodo que recupera un producto dado su ID
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    //Metodo que Guarda un producto
    public Producto saveProducto(Producto productoAGuardar){
        return productoCrudRepository.save(productoAGuardar);
    };

    //Metodo que elimina un producto por su id

    public void deleteProducto(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
