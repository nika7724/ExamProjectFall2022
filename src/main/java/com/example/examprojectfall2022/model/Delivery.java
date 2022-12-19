package com.example.examprojectfall2022.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String warehouse;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String destination;

    @OneToMany
            (mappedBy = "delivery", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    Set<ProductOrder> productOrder = new HashSet<>();

    public Delivery(LocalDate deliveryDate, String warehouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.warehouse = warehouse;
        this.destination = destination;
    }

}
