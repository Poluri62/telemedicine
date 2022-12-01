package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.AppointmentDetailsPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Appointment_Details")
@IdClass(AppointmentDetailsPK.class)
public class AppointmentDetails {
    @Id
    @Column(name = "appointment_id")
    String appointmentId;

    @Id
    @Column(name = "service_id")
    String serviceId;

    @Id
    @Column(name = "patient_id")
    String patientId;

    @Id
    @Column(name = "doctor_id")
    String doctorId;

    @Column(name = "appointment_date")
    Date appointmentDate;

    @Column(name = "appointment_time")
    String appointmentTime;

    @Column(name = "appointment_status")
    String appointmentStatus;
}
