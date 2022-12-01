package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.Patient;
import com.dbms.telemedicine.model.SystemAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAdminRepository extends CrudRepository<SystemAdmin, String>{
    SystemAdmin getByEmailId(String emailId);
}