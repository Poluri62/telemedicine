package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.CompositeKeys.PatientContactId;
import com.dbms.telemedicine.model.PatientContact;
import com.dbms.telemedicine.repository.PatientContactRepository;
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
public class PatientContactController {

    @Autowired
    PatientContactRepository patientContactRepository;

    @GetMapping("/getAllPatientContacts")
    @ResponseBody
    public List<PatientContact> getAllPatientContacts(){
        return StreamSupport.stream(patientContactRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getPatientContactsById/{id}")
    @ResponseBody
    public List<PatientContact> getPatientContactsById(@PathVariable String id){
        return patientContactRepository.getAllByPatientId(id);
    }

    @PostMapping("/addPatientContact")
    @ResponseBody
    public ResponseEntity addPatient(@RequestBody PatientContact patientContact){
        try{
            patientContactRepository.save(patientContact);
            //login
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deletePatientContact/{patientId}/{phoneNumber}")
    @ResponseBody
    public ResponseEntity deletePatientById(@PathVariable String patientId, @PathVariable String phoneNumber){
        try{
            patientContactRepository.deleteById(new PatientContactId(patientId, phoneNumber));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
