package com.example.demo.user.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        return patientRepository.findById(id)
            .map(patient -> {
                if (updatedPatient.getName() != null) patient.setName(updatedPatient.getName());
                if (updatedPatient.getEmail() != null) patient.setEmail(updatedPatient.getEmail());
                if (updatedPatient.getPhone() != null) patient.setPhone(updatedPatient.getPhone());
                if (updatedPatient.getPassword() != null) patient.setPassword(updatedPatient.getPassword());
                if (updatedPatient.getMedicalHistory() != null) patient.setMedicalHistory(updatedPatient.getMedicalHistory());
                return ResponseEntity.ok(patientRepository.save(patient));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
