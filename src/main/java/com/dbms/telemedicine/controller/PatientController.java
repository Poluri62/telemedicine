package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.Patient;
import com.dbms.telemedicine.repository.PatientRepository;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/getPatients")
    @ResponseBody
    public List<Patient> getPatients(){
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getPatientById/{id}")
    @ResponseBody
    public Patient getPatientById(@PathVariable String id){
        return patientRepository.findById(id).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addPatient")
    @ResponseBody
    public ResponseEntity addPatient(@RequestBody Patient patient){
        try{
            patientRepository.save(patient);
            //login
        } catch(Exception e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deletePatient/{id}")
    @ResponseBody
    public ResponseEntity deletePatientById(@PathVariable String id){
        try{
            patientRepository.deleteById(id);
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
