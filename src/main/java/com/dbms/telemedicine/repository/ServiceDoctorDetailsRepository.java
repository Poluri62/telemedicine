package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.CompositeKeys.ServiceDoctorDetailsPK;
import com.dbms.telemedicine.model.ServiceDoctorDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDoctorDetailsRepository extends CrudRepository<ServiceDoctorDetails, ServiceDoctorDetailsPK>{
    List<ServiceDoctorDetails> getAllByServiceId(String serviceId);
    List<ServiceDoctorDetails> getAllByDoctorId(String doctorId);
}