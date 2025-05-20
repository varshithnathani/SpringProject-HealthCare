package com.example.demo.config;

import com.example.demo.user.Doctor;
import com.example.demo.user.Patient;
import com.example.demo.user.DoctorRepository;
import com.example.demo.user.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadInitialData(DoctorRepository doctorRepo, PatientRepository patientRepo) {
        return args -> {
            if (doctorRepo.count() == 0) {
                doctorRepo.save(new Doctor(null, "Dr. John Doe", "johndoe@example.com", "9876543210", "securepassword", "Cardiologist"));
            }
            if (patientRepo.count() == 0) {
                patientRepo.save(new Patient(null, "John Smith", "johnsmith@example.com", "9876543211", "securepassword", "No prior medical issues"));
            }
        };
    }
}
