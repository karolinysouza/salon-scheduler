package com.karol.salon_scheduler.infrastructure.repository;

import com.karol.salon_scheduler.infrastructure.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
}
