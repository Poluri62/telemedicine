package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.AppointmentDetails;
import com.dbms.telemedicine.model.CompositeKeys.AppointmentDetailsPK;
import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
import com.dbms.telemedicine.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, PaymentPK>{
    List<Payment> getAllByPaymentId(String paymentId);
    List<Payment> getAllByAppointmentId(String appointmentId);
}