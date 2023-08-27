package com.platzi.APIPlatziMarket.persistence;

import com.platzi.APIPlatziMarket.persistence.crud.ProductoCrudRepository;
import com.platzi.APIPlatziMarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Metodo que Recupera todos los productos de la BD
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
