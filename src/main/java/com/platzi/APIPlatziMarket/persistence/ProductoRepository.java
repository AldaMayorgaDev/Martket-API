package com.platzi.APIPlatziMarket.persistence;

import com.platzi.APIPlatziMarket.domain.Product;
import com.platzi.APIPlatziMarket.domain.repository.ProductRespository;
import com.platzi.APIPlatziMarket.persistence.crud.ProductoCrudRepository;
import com.platzi.APIPlatziMarket.persistence.entity.Producto;
import com.platzi.APIPlatziMarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository //Con la anotacion Repository indicamos a Spring que esta clase se encarga de interactuar con la BD
public class ProductoRepository implements ProductRespository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    //Metodo que Recupera todos los productos de la BD
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    //Metodo que retorna una lista con todos los productos que pertenecen a una categoria especifica utlizando el QueryMethod creado
    @Override
    public Optional<List<Product>> getByCategory(int CategoryId){
        List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(CategoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    // Metodo que recupera todos los productos que su cantidad en stock son menores a (cantidad) y que su estado sea igual a true
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>>productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    //Metodo que recupera un producto dado su ID
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    //Metodo que Guarda un producto
    @Override
    public Product saveProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //Metodo que elimina un producto por su id
    @Override
    public void deleteProduct(int ProductId) {
        productoCrudRepository.deleteById(ProductId);
    }
}
