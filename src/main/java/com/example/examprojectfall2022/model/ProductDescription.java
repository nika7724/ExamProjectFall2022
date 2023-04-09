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
@Table(name = "product_description")
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String productDescription;

    @OneToMany
            (mappedBy = "productDescription", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    Set<Product> product = new HashSet<>();


    public ProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
