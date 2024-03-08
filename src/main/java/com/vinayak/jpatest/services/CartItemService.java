package com.vinayak.jpatest.services;

import com.vinayak.jpatest.exceptions.EntityNotFoundException;
import com.vinayak.jpatest.models.CartItem;
import com.vinayak.jpatest.models.Customer;
import com.vinayak.jpatest.models.Product;
import com.vinayak.jpatest.repositories.CartItemRepository;
import com.vinayak.jpatest.repositories.CustomerRepository;
import com.vinayak.jpatest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<CartItem> getAll() {
        return cartItemRepository.findAll();
    }

    public List<CartItem> getCartItem(@PathVariable int id) {

        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            return cartItemRepository.findByCustomer(customerOptional.get());

        }
        throw new EntityNotFoundException("Cart Item with given ID is not present");
    }

    public CartItem createCartItem(CartItem cartItem) {

        Optional<Product> productOptional = productRepository.findById(cartItem.getProduct().getId());
        Optional<Customer> customerOptional = customerRepository.findById(cartItem.getCustomer().getId());

        if (productOptional.isPresent() && customerOptional.isPresent() && cartItem.getQuantity() > 0) {
            return cartItemRepository.save(cartItem);
        }
        throw new EntityNotFoundException("Product or Customer with given ID doesn't exists");
    }


    public String deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
        return "Cart Item deleted";
    }
}
