package com.karol.salon_scheduler.controller;

import com.karol.salon_scheduler.infrastructure.entity.Appointment;
import com.karol.salon_scheduler.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.saveAppointment(appointment));
    }

    @DeleteMapping
    public  ResponseEntity<Void> deleteAppointment(
            @RequestParam String clientName,
            @RequestParam LocalDateTime appointmentDateTime) {
        appointmentService.deleteAppointment(appointmentDateTime, clientName);
        return ResponseEntity.noContent().build();
    }
}
