package com.crescent.hms.doctor.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., Dermatology, Cardiology
}