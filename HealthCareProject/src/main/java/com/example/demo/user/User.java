package com.example.demo.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString  // we are using lombok in place of getter, setter, constructor, toString 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String role; // "DOCTOR" or "PATIENT"

    // Default Constructor
//    public User() {}
//
//    // Parameterized Constructor
//    public User(String name, String email, String phone, String password, String role) {
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//        this.role = role;
//    }
//
//    // Getters and Setters
//    public Long getUserId() { return userId; }
//    public void setUserId(Long userId) { this.userId = userId; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getRole() { return role; }
//    public void setRole(String role) { this.role = role; }
    
}
