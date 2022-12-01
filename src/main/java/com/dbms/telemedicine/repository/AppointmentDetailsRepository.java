package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.AppointmentDetails;
import com.dbms.telemedicine.model.CompositeKeys.AppointmentDetailsPK;
import com.dbms.telemedicine.model.CompositeKeys.ServiceDoctorDetailsPK;
import com.dbms.telemedicine.model.ServiceDoctorDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDetailsRepository extends CrudRepository<AppointmentDetails, AppointmentDetailsPK>{
    List<AppointmentDetails> getAllByServiceId(String serviceId);
    List<AppointmentDetails> getAllByAppointmentId(String appointmentId);
    List<AppointmentDetails> getAllByPatientId(String patientId);
    List<AppointmentDetails> getAllByDoctorId(String doctorId);
}