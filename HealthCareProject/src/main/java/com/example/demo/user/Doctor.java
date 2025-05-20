package com.example.demo.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Doctor extends UserBase {
    private String specialization;

    // Constructor matching DataLoader arguments
    public Doctor(Long userId, String name, String email, String phone, String password, String specialization) {
        super(userId, name, email, phone, password);
        this.specialization = specialization;
    }
}
