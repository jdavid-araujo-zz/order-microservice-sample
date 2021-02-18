package com.order.productservice.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_category")
@Entity
public class Category {

    @Id
    private Long id;

    private String name;
}
