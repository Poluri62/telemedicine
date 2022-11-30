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
@Table(name = "Patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    String patientId;

    @Column(name = "patient_name")
    String patientName;

    @Column(name = "gender")
    String gender;

    @Column(name = "date_of_birth")
    Date dateOfBirth;

    @Column(name = "blood_group")
    String bloodGroup;

    @Column(name = "address")
    String address;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "password")
    String password;
}
