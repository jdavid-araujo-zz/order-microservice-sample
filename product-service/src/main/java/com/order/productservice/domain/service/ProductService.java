package com.order.productservice.domain.service;

import com.order.productservice.domain.entity.Category;
import com.order.productservice.domain.entity.Product;
import com.order.productservice.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public void save(Product entity) {

    }

    public void update(Long id, Product product) {
        if(!this.isExist(id)) {

        }
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        if(!this.isExist(id)) {

        }

        return this.productRepository.findById(id);
    }

    private boolean isExist(Long id) {
        return this.productRepository.existsById(id);
    }
}
