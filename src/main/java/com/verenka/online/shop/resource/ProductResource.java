package com.verenka.online.shop.resource;

import com.verenka.online.shop.entity.Product;
import com.verenka.online.shop.service.ProductService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(value = "page", defaultValue = "1") int page,
														@RequestParam(value = "size", defaultValue = "8") int size) {
		Page<Product> products = productService.getProducts(page - 1, size);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Optional<Product> product = productService.getProductById(id);
		if(product.isPresent())
			return ResponseEntity.ok(product.get());
		else
			return ResponseEntity.notFound().build();
	}
}
