package com.verenka.online.shop;

import com.verenka.online.shop.entity.Product;
import com.verenka.online.shop.repository.ProductRepository;
import java.time.Instant;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			if (productRepository.findAll().size() < 1) {
				for (int i = 0; i < 100; i++) {
					Random r = new Random();
					productRepository.save(new Product("Cup" + (i + 1),
						"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!",
						r.nextInt(100) + 1, Instant.now().toEpochMilli()));
				}
			}
		};
	}
}
