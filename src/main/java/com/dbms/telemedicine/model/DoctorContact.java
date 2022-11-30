package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.DoctorContactPK;
import com.dbms.telemedicine.model.CompositeKeys.PatientContactPK;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Doctor_Contact")
@IdClass(DoctorContactPK.class)
public class DoctorContact {
    @Id
    @Column(name = "doctor_id")
    String doctorId;

    @Id
    @Column(name = "phone_number")
    String phoneNumber;
}
