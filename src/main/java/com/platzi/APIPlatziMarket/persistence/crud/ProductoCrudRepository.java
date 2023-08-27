package com.platzi.APIPlatziMarket.persistence.crud;

import com.platzi.APIPlatziMarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    
    //Query Method que recupera todos los productos que pertenecen a una categoria especifica y ordena ascendente
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Query Method con operadores opcionales de Java
    // Metodo que recupera todos los productos que su cantidad en estock son menores a (Parametro) y que su estado sea igual a (parametro)
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
