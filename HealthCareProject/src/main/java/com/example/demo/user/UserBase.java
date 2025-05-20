package com.example.demo.user;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public abstract class UserBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phone;
    private String password;
}
