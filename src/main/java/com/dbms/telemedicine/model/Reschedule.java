package com.dbms.telemedicine.model;

import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
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
@Table(name = "Reschedule")
@IdClass(ReschedulePK.class)
public class Reschedule {
    @Id
    @Column(name = "appointment_id")
    String appointmentId;

    @Id
    @Column(name = "doctor_id")
    String doctorId;

    @Column(name = "new_date")
    Date newDate;

    @Column(name = "new_time")
    Time new_time;
}
