package com.example.examprojectfall2022.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INTEGER(10)")
    private int quantity;

    public ProductOrder(int quantity) {
        this.quantity = quantity;
    }

}
