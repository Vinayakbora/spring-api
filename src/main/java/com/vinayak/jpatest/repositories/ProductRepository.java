package com.vinayak.jpatest.repositories;

import com.vinayak.jpatest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
