package com.example.examprojectfall2022.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String productName;
    @Column
    private double price;
    @Column
    private double weight;

    @OneToMany
            (mappedBy = "product", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
        @JsonBackReference
        Set<ProductOrder> productOrder = new HashSet<>();


    public Product(String productName, double price, double weight) {
        this.productName = productName;
        this.price = price;
        this.weight = weight;
    }

}
