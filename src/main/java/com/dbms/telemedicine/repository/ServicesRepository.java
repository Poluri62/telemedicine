package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends CrudRepository<Services, String>{

}