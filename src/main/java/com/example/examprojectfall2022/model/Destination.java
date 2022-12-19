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
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String fullName;
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String address;

    @OneToMany
            (mappedBy = "destination", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    Set<Delivery> delivery = new HashSet<>();

    public Destination(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

}
