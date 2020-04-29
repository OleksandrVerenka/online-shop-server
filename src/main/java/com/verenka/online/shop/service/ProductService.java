package com.verenka.online.shop.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import com.verenka.online.shop.entity.Product;

public interface ProductService {

	Page<Product> getProducts(int page, int size);

	Optional<Product> getProductById(String id);
}
