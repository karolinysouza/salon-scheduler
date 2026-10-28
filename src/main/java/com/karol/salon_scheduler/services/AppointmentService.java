package com.karol.salon_scheduler.services;

import com.karol.salon_scheduler.infrastructure.entity.Appointment;
import com.karol.salon_scheduler.infrastructure.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(Appointment appointment) {
        LocalDateTime startTime = appointment.getAppointmentDateTime();

        LocalDateTime endTime = startTime.plusHours(1).minusMinutes(1);

        Appointment existingAppointment = appointmentRepository.findByServiceTypeAndAppointmentDateTimeBetween(appointment.getServiceType(), startTime, endTime);

        if (Objects.nonNull(existingAppointment)) {
            throw new RuntimeException("Time slot is already booked");
        }

        return appointmentRepository.save(appointment);
    }
}

