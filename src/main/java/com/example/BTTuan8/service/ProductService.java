package com.example.BTTuan8.service;

import com.example.BTTuan8.Repository.IProductRepository;
import com.example.BTTuan8.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public void add(Product newProduct) {
        productRepository.save(newProduct);
    }

    public List<Product> getAll() {
            return productRepository.findAll();
    }

    public Product get(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void update(Product updatedProduct) {
        productRepository.save(updatedProduct);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
