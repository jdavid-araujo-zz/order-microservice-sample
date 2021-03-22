package com.order.productservice.domain.service;


import com.order.productservice.domain.entity.Product;
import com.order.productservice.domain.exception.NegocioException;
import com.order.productservice.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private MessageSource messageSource;

    private ProductRepository productRepository;

    public void save(Product entity) {
        try {
            this.productRepository.save(entity);
        } catch (Exception ex) {
            throw new NegocioException(messageSource.getMessage("operation.failed", null, LocaleContextHolder.getLocale()));
        }
    }

    public void update(Long id, Product product) {
        if(!this.isExist(id)) {
            throw new NegocioException(String.format("Product does not found with the id: %d", id));
        }

    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        if(!this.isExist(id)) {
            throw new NegocioException(String.format("Product does not found with the id: %d", id));
        }

        return this.productRepository.findById(id).orElseThrow(() -> new NegocioException(String.format("It was not possible to proceed with the operation for the product with id: %d", id)));
    }

    private boolean isExist(Long id) {
        return this.productRepository.existsById(id);
    }
}
