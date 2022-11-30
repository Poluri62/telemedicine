package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.PatientReportPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Patient_Report")
@IdClass(PatientReportPK.class)
public class PatientReport {
    @Id
    @Column(name = "patient_id")
    String patientId;

    @Id
    @Column(name = "patient_report_id")
    String patientReportId;

    @Column(name = "symptoms")
    String symptoms;

    @Column(name = "additional_description")
    String additionalDescription;

    @Column(name = "diagnosis")
    String diagnosis;
}
