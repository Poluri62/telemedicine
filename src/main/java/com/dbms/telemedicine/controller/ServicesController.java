package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.Doctor;
import com.dbms.telemedicine.model.Services;
import com.dbms.telemedicine.repository.DoctorRepository;
import com.dbms.telemedicine.repository.ServicesRepository;
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
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    ServicesRepository servicesRepository;

    @GetMapping("/getServices")
    @ResponseBody
    public List<Services> getAllServices(){
        return StreamSupport.stream(servicesRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getServicesById/{id}")
    @ResponseBody
    public Services getServicesById(@PathVariable String id){
        return servicesRepository.findById(id).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addServices")
    @ResponseBody
    public ResponseEntity addServices(@RequestBody Services service){
        try{
            servicesRepository.save(service);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insert Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteServices/{id}")
    @ResponseBody
    public ResponseEntity deleteServicesById(@PathVariable String id){
        try{
            servicesRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
