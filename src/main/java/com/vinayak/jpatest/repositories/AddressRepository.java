package com.vinayak.jpatest.repositories;

import com.vinayak.jpatest.models.Address;
import com.vinayak.jpatest.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    public List<Address> findByCustomer(Customer customer);

}
