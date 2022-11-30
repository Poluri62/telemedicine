package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.CompositeKeys.DoctorContactPK;
import com.dbms.telemedicine.model.CompositeKeys.PatientContactPK;
import com.dbms.telemedicine.model.DoctorContact;
import com.dbms.telemedicine.model.PatientContact;
import com.dbms.telemedicine.repository.DoctorContactRepository;
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
@RequestMapping("/doctor")
public class DoctorContactController {

    @Autowired
    DoctorContactRepository doctorContactRepository;

    @GetMapping("/getAllDoctorContacts")
    @ResponseBody
    public List<DoctorContact> getAllDoctorContacts(){
        return StreamSupport.stream(doctorContactRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getDoctorContactsById/{id}")
    @ResponseBody
    public List<DoctorContact> getDoctorContactsById(@PathVariable String id){
        return doctorContactRepository.getAllByDoctorId(id);
    }

    @PostMapping("/addDoctorContact")
    @ResponseBody
    public ResponseEntity addDoctor(@RequestBody DoctorContact doctorContact){
        try{
            doctorContactRepository.save(doctorContact);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteDoctorContact")
    @ResponseBody
    public ResponseEntity deletePatientById(@RequestParam String doctorId, @RequestParam String phoneNumber){
        try{
            doctorContactRepository.deleteById(new DoctorContactPK(doctorId, phoneNumber));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
