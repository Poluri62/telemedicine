package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.PatientContactPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Patient_Contact")
@IdClass(PatientContactPK.class)
public class PatientContact {
    @Id
    @Column(name = "patient_id")
    String patientId;

    @Id
    @Column(name = "phone_number")
    String phoneNumber;
}
