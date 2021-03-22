package com.order.productservice.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
@Table(name = "tb_product")
@Entity
public class Product {

    @Id
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal value;

    @ManyToOne
    private Category category;

    @Version
    private Long version;
}
