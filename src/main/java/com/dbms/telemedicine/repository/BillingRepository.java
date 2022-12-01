package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.Billing;
import com.dbms.telemedicine.model.CompositeKeys.BillingPK;
import com.dbms.telemedicine.model.CompositeKeys.RepresentativePK;
import com.dbms.telemedicine.model.Representative;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends CrudRepository<Billing, BillingPK>{

}