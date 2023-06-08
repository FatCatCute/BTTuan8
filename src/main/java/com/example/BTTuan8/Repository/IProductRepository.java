package com.example.BTTuan8.Repository;

import com.example.BTTuan8.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByPrice(Long price);
    List<Product> findByNameAndPrice(String name, Long price);
}
