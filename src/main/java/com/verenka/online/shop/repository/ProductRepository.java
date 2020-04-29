package com.verenka.online.shop.repository;

import com.verenka.online.shop.entity.Product;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {

	Optional<Product> findById(String id);
}
