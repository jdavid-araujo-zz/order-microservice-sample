package com.order.productservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "tb_category")
@Entity
public class Category {

    @Id
    private Long id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
}
