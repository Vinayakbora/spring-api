package com.vinayak.jpatest.repositories;

import com.vinayak.jpatest.models.CartItem;
import com.vinayak.jpatest.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

    public List<CartItem> findByCustomer(Customer customer);

}
