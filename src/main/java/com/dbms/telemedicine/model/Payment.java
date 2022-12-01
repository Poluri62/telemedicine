package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.AppointmentDetailsPK;
import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
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
@Table(name = "Payment")
@IdClass(PaymentPK.class)
public class Payment {
    @Id
    @Column(name = "payment_id")
    String paymentId;

    @Id
    @Column(name = "appointment_id")
    String appointmentId;

    @Column(name = "amount")
    int amount;

    @Column(name = "payment_date")
    Date paymentDate;

    @Column(name = "payment_time")
    Time paymentTime;

    @Column(name = "payment_status")
    String paymentStatus;

    @Column(name = "payment_mode")
    String paymentMode;
}
