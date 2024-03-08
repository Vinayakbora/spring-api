package com.vinayak.jpatest.services;

import com.vinayak.jpatest.exceptions.EntityAlreadyExistsException;
import com.vinayak.jpatest.exceptions.EntityNotFoundException;
import com.vinayak.jpatest.models.Product;
import com.vinayak.jpatest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProduct(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new EntityNotFoundException("Product With given ID is not present");
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }
}
