package com.example.examprojectfall2022.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;
    @Column
    private double price;
    @Column
    private double weight;

    public Product(Long id, String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

}
