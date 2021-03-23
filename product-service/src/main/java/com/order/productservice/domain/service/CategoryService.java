package com.order.productservice.domain.service;

import com.order.productservice.domain.entity.Category;
import com.order.productservice.domain.exception.NegocioException;
import com.order.productservice.domain.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private MessageSource messageSource;

    private CategoryRepository categoryRepository;

    public void save(Category entity) {
        try {
            this.categoryRepository.save(entity);
        } catch (Exception e) {
            throw new NegocioException(messageSource.getMessage("operation.failed", null, LocaleContextHolder.getLocale()));
        }
    }

    public void update(Long id, Category entity) {
        if (!this.isExist(id)) {
            throw new NegocioException(String.format("Categoty does not found with the id: %d", id));
        }

        Category category = this.findById(id);

        BeanUtils.copyProperties(entity, category, "id");

        this.save(category);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        if (!this.isExist(id)) {
            throw new NegocioException(String.format("Categoty does not found with the id: %d", id));
        }

        return this.categoryRepository.findById(id).orElseThrow(() -> new NegocioException(String.format("It was not possible to proceed with the operation for the category with id: %d", id)));
    }

    private boolean isExist(Long id) {
        return this.categoryRepository.existsById(id);
    }

}
