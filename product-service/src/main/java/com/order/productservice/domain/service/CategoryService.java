package com.order.productservice.domain.service;

import com.order.productservice.domain.entity.Category;
import com.order.productservice.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public void save(Category category) {
        try {
            this.categoryRepository.save(category);
        } catch (Exception e) {

        }
    }

    public void update(Long id, Category category) {

    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        if(!this.isExist(id)) {

        }

        return this.categoryRepository.findById(id);
    }

    private boolean isExist(Long id) {
        return this.categoryRepository.existsById(id);
    }

}
