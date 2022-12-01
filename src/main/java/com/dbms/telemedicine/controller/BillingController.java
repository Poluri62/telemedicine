package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.Billing;
import com.dbms.telemedicine.model.CompositeKeys.BillingPK;
import com.dbms.telemedicine.model.CompositeKeys.RepresentativePK;
import com.dbms.telemedicine.model.Representative;
import com.dbms.telemedicine.repository.BillingRepository;
import com.dbms.telemedicine.repository.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    BillingRepository billingRepository;

    @GetMapping("/getAllBillings")
    @ResponseBody
    public List<Billing> getAllBillings(){
        return StreamSupport.stream(billingRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getBillingByIds")
    @ResponseBody
    public Billing getBillingByIds(@RequestParam String billingId, @RequestParam String paymentId, @RequestParam String patientId, @RequestParam String representativeId){
        return billingRepository.findById(new BillingPK(billingId, paymentId, patientId, representativeId)).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addBilling")
    @ResponseBody
    public ResponseEntity addBilling(@RequestBody Billing billing){
        try{
            billingRepository.save(billing);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data Integrity violated");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteBilling")
    @ResponseBody
    public ResponseEntity deleteBilling(@RequestParam String billingId, @RequestParam String paymentId, @RequestParam String patientId, @RequestParam String representativeId){
        try{
            billingRepository.deleteById(new BillingPK(billingId, paymentId, patientId, representativeId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
