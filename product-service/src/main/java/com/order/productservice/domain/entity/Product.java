package com.order.productservice.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "tb_product")
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;
}
