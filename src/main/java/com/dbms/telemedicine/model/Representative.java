package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.RepresentativePK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Representative")
@IdClass(RepresentativePK.class)
public class Representative {
    @Id
    @Column(name = "representative_id")
    String representativeId;

    @Id
    @Column(name = "patient_id")
    String patientId;

    @Column(name = "representative_name")
    String representativeName;

    @Column(name = "relationship")
    Date relationship;

    @Column(name = "address")
    String address;

    @Column(name = "contact")
    String contact;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "password")
    String password;
}
