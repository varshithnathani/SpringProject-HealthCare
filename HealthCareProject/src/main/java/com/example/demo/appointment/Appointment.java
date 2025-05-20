package com.example.demo.appointment;

import com.example.demo.user.Doctor;
import com.example.demo.user.Patient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appointments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne(cascade = CascadeType.PERSIST) // Ensure Patient exists before inserting an Appointment
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST) // Ensure Doctor exists before inserting an Appointment
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private String timeSlot;
    private String status; // "BOOKED", "CANCELLED", "COMPLETED"
}


//package com.example.demo.appointment;
//
//import com.example.demo.user.User;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "appointments")
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
//public class Appointment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long appointmentId;
//
//    @ManyToOne
//    @JoinColumn(name = "patient_id", nullable = false)
//    private User patient;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id", nullable = false)
//    private User doctor;
//
//    private String timeSlot;
//    private String status; // "BOOKED", "CANCELLED", "COMPLETED"
//}
//
