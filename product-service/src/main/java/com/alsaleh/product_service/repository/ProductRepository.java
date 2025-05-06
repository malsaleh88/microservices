package com.alsaleh.product_service.repository;

import com.alsaleh.product_service.modul.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {



}
