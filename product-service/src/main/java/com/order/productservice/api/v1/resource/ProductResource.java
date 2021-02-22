package com.order.productservice.api.v1.resource;

import com.order.productservice.domain.entity.Product;
import com.order.productservice.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductResource {

    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Product product) {
        this.productService.save(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public void update(@PathVariable(value = "id", required = true) Long id, @RequestBody(required = true) Product product) {
        this.productService.update(id, product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productService.findAll();

        return ResponseEntity.ok(products);
    }

    public ResponseEntity<Product> findById(@PathVariable(value = "ïd", required = true) Long id) {
        Product product = this.productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id", required = true) Long id) {
        this.productService.findById(id);
    }
}
