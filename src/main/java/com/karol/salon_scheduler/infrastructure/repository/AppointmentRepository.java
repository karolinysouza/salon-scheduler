package com.karol.salon_scheduler.infrastructure.repository;

import com.karol.salon_scheduler.infrastructure.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByServiceTypeAndAppointmentDateTimeBetween(
            String serviceType, LocalDateTime startTime, LocalDateTime endTime);

    @Transactional
    void deleteByAppointmentDateTimeAndClientName(
            LocalDateTime appointmentDateTime, String clientName);

    List<Appointment> findByAppointmentDateTimeBetween(
            LocalDateTime startTime, LocalDateTime endTime);

    Appointment findByAppointmentDateTimeAndClientName(
            LocalDateTime appointmentDateTime, String clientName);
}
