package com.example.examprojectfall2022.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

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
    private String wareHouse;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String destination;

    public Delivery(LocalDate deliveryDate, String wareHouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.wareHouse = wareHouse;
        this.destination = destination;
    }

}
