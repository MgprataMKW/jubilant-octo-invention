package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Create an implementation of a Rest API .
 * Expose an API. Feel free to explore possibilities/functionalities/capabilities following Rest standard.
 * We suggest that your implementation have at least a CRUD scenario.
 *
 */

@SpringBootApplication
@RestController
@RequestMapping("/api/products")
public class TASK5 {
	
	// Product class
    public static class Product {
        private Long id;
        private String name;
        private double price;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    // Storing products
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    // Creating product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	System.out.println("Iniciando criação de um novo produto...");
        product.setId(nextId++);
        products.add(product);
        System.out.println("Novo produto criado com sucesso. ID: " + product.getId() + ", Nome: " + product.getName() + ", Preço: " + product.getPrice());
        return product;
    }

    // Getting all products
    @GetMapping
    public List<Product> getAllProducts() {
    	System.out.println("Recuperando lista de todos os produtos...");
        return products;
    }

    // Getting product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
    	System.out.println("Buscando produto com ID: " + id + "...");
        Optional<Product> product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (product.isPresent()) {
        	System.out.println("Produto encontrado: ID: " + id + ", Nome: " + product.get().getName() + ", Preço: " + product.get().getPrice());
            return product.get();
        } else {
        	System.out.println("Produto com ID: " + id + " não encontrado");
            return null;
        }
    }

    // Updating product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    	System.out.println("Iniciando atualização do produto com ID: " + id + "...");
        Optional<Product> existingProduct = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            System.out.println("Produto com ID: " + id + " atualizado com sucesso");
            return product;
        } else {
        	System.out.println("Produto com ID: " + id + " não encontrado para atualização");
            return null;
        }
    }

    // Deleting product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    	System.out.println("Iniciando exclusão do produto com ID: " + id + "...");
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        if (removed) {
        	System.out.println("Produto com ID: " + id + " excluído com sucesso.");
        } else {
        	System.out.println("Produto com ID: " + id + " não encontrado para exclusão.");
        }
    }

    // Main Function
    public static void main(String[] args) {
    	System.out.println("Iniciando a aplicação TASK5...");
        SpringApplication.run(TASK5.class, args);
        System.out.println("Aplicação TASK5 iniciada com sucesso.");
    }
}