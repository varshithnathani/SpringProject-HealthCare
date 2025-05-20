package com.example.demo.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "patients")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient extends UserBase {
    private String medicalHistory;

    // Constructor matching DataLoader arguments
    public Patient(Long userId, String name, String email, String phone, String password, String medicalHistory) {
        super(userId, name, email, phone, password); // Call UserBase constructor
        this.medicalHistory = medicalHistory;
    }
}
