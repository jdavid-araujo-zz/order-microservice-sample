package com.order.productservice.domain.service;

import com.order.productservice.domain.entity.Category;
import com.order.productservice.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public void save(Category category) {

    }

    public void update(Long id, Category category) {

    }

    public List<Category> findALl() {
        return this.categoryRepository.findAll();
    }
}
