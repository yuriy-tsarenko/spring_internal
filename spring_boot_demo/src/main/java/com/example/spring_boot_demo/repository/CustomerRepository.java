package com.example.spring_boot_demo.repository;

import com.example.spring_boot_demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findCustomerEntityById(Long id);
}
