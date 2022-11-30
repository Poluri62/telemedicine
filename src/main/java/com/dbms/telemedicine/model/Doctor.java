package com.dbms.telemedicine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    String doctorId;

    @Column(name = "doctor_name")
    String doctorName;

    @Column(name = "gender")
    String gender;

    @Column(name = "specialization")
    String specialization;

    @Column(name = "working_hours")
    String workingHours;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "password")
    String password;
}
