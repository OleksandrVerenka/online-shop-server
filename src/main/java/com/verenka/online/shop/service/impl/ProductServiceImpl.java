package com.verenka.online.shop.service.impl;

import com.verenka.online.shop.entity.Product;
import com.verenka.online.shop.repository.ProductRepository;
import com.verenka.online.shop.service.ProductService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	private static final String SORT_BY_FIELD = "creationDate";

	@Autowired
	ProductRepository productRepository;

	@Override
	public Page<Product> getProducts(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(SORT_BY_FIELD).descending());
		return productRepository.findAll(pageRequest);
	}

	@Override
	public Optional<Product> getProductById(String id) {
		return productRepository.findById(id);
	}
}
