package com.example.demo.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Map<String, Object> requestData) {
        Long patientId = Long.parseLong(requestData.get("patientId").toString());
        Long doctorId = Long.parseLong(requestData.get("doctorId").toString());
        String timeSlot = requestData.get("timeSlot").toString();
        
        return ResponseEntity.ok(appointmentService.bookAppointment(patientId, doctorId, timeSlot));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(id));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentsForPatient(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForPatient(id));
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentsForDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForDoctor(id));
    }
}
