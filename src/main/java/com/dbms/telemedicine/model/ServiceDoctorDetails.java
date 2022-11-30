package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.ServiceDoctorDetailsPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service_Doctor_Details")
@IdClass(ServiceDoctorDetailsPK.class)
public class ServiceDoctorDetails {
    @Id
    @Column(name = "service_id")
    String serviceId;

    @Id
    @Column(name = "doctor_id")
    String doctorId;

    @Column(name = "charges")
    int charges;

    @Column(name = "availability")
    String availability;
}
