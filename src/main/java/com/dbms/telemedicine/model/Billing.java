package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.BillingPK;
import com.dbms.telemedicine.model.CompositeKeys.ReschedulePK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Billing")
@IdClass(BillingPK.class)
public class Billing {
    @Id
    @Column(name = "billing_id")
    String billingId;

    @Id
    @Column(name = "payment_id")
    String paymentId;

    @Id
    @Column(name = "patient_id")
    String patientId;

    @Id
    @Column(name = "representative_id")
    String representativeId;
}
