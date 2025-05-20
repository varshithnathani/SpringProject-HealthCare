package com.example.demo.user.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorRepository.save(doctor));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        return doctorRepository.findById(id)
            .map(doctor -> {
                if (updatedDoctor.getName() != null) doctor.setName(updatedDoctor.getName());
                if (updatedDoctor.getEmail() != null) doctor.setEmail(updatedDoctor.getEmail());
                if (updatedDoctor.getPhone() != null) doctor.setPhone(updatedDoctor.getPhone());
                if (updatedDoctor.getPassword() != null) doctor.setPassword(updatedDoctor.getPassword());
                if (updatedDoctor.getSpecialization() != null) doctor.setSpecialization(updatedDoctor.getSpecialization());
                return ResponseEntity.ok(doctorRepository.save(doctor));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
