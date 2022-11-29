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
    String patient_id;

    @Column(name = "patient_name")
    String patient_name;

    @Column(name = "gender")
    String gender;

    @Column(name = "date_of_birth")
    Date date_of_birth;

    @Column(name = "blood_group")
    String blood_group;

    @Column(name = "address")
    String address;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "password")
    String password;
}
