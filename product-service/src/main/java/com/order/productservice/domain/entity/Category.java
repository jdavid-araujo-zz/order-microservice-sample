package com.order.productservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_category")
@Entity
public class Category {

    @EqualsAndHashCode.Include
    @Id
    private Long id;

    @NotBlank
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    @Version
    private Long version;
}
