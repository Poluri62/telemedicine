package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
import com.dbms.telemedicine.model.CompositeKeys.ReschedulePK;
import com.dbms.telemedicine.model.Payment;
import com.dbms.telemedicine.model.Reschedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RescheduleRepository extends CrudRepository<Reschedule, ReschedulePK>{
    List<Reschedule> getAllByDoctorId(String doctorId);
    List<Reschedule> getAllByAppointmentId(String appointmentId);
}