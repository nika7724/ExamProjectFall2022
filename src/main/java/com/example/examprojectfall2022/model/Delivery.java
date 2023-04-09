package com.example.examprojectfall2022.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

      @OneToMany
            (mappedBy = "delivery", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    Set<ProductOrder> productOrder = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "warehouse", foreignKey = @ForeignKey(name = "fk_warehouse"), referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "destination", foreignKey = @ForeignKey(name = "fk_destination"), referencedColumnName = "id")
    private Destination destination;

    public Delivery(LocalDate deliveryDate, Warehouse warehouse, Destination destination) {
        this.deliveryDate = deliveryDate;
        this.warehouse = warehouse;
        this.destination = destination;

    }

}
