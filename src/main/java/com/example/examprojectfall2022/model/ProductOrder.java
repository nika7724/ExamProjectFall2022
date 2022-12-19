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


    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_id"), referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "delivery_id", foreignKey = @ForeignKey(name = "fk_delivery_id"), referencedColumnName = "id")
    private Delivery delivery;

    public ProductOrder(int quantity, Product product, Delivery delivery) {
        this.quantity = quantity;
        this.product = product;
        this.delivery = delivery;
    }

}
