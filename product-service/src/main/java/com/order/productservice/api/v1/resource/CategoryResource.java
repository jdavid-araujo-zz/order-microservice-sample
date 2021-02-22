package com.order.productservice.api.v1.resource;

import com.order.productservice.domain.entity.Category;
import com.order.productservice.domain.entity.Product;
import com.order.productservice.domain.service.CategoryService;
import com.order.productservice.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/categories")
public class CategoryResource {

    private CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Category category) {
        this.categoryService.save(category);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public void update(@PathVariable(value = "id", required = true) Long id, @RequestBody(required = true) Category category) {
        this.categoryService.update(id, category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    public ResponseEntity<Category> findById(@PathVariable(value = "ïd", required = true) Long id) {
        Category category = this.categoryService.findById(id);

        return ResponseEntity.ok(category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id", required = true) Long id) {
        this.categoryService.findById(id);
    }
}
