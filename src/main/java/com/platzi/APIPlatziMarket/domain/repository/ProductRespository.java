package com.platzi.APIPlatziMarket.domain.repository;

import com.platzi.APIPlatziMarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRespository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product saveProduct(Product product);
    void deleteProduct(int ProductId);
}
