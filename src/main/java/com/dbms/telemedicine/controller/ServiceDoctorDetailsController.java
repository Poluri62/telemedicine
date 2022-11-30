package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.CompositeKeys.PatientReportPK;
import com.dbms.telemedicine.model.CompositeKeys.ServiceDoctorDetailsPK;
import com.dbms.telemedicine.model.PatientReport;
import com.dbms.telemedicine.model.ServiceDoctorDetails;
import com.dbms.telemedicine.repository.PatientReportRepository;
import com.dbms.telemedicine.repository.ServiceDoctorDetailsRepository;
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
@RequestMapping("/serviceDoctorDetails")
public class ServiceDoctorDetailsController {

    @Autowired
    ServiceDoctorDetailsRepository serviceDoctorDetailsRepository;

    @GetMapping("/getAllServiceDoctorDetails")
    @ResponseBody
    public List<ServiceDoctorDetails> getAllServiceDoctorDetails(){
        return StreamSupport.stream(serviceDoctorDetailsRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getAllServiceDoctorDetailsbyServiceId/{serviceId}")
    @ResponseBody
    public List<ServiceDoctorDetails> getAllServiceDoctorDetailsbyServiceId(@PathVariable String serviceId){
        return serviceDoctorDetailsRepository.getAllByServiceId(serviceId);
    }

    @GetMapping("/getAllServiceDoctorDetailsbyDoctorId/{doctorId}")
    @ResponseBody
    public List<ServiceDoctorDetails> getAllServiceDoctorDetailsbyDoctorId(@PathVariable String doctorId){
        return serviceDoctorDetailsRepository.getAllByDoctorId(doctorId);
    }

    @PostMapping("/addServiceDoctorDetails")
    @ResponseBody
    public ResponseEntity addServiceDoctorDetails(@RequestBody ServiceDoctorDetails serviceDoctorDetails){
        try{
            serviceDoctorDetailsRepository.save(serviceDoctorDetails);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Foreign Key Constraint violated: Doctor Id or Service Id does not exist");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteServiceDoctorDetails")
    @ResponseBody
    public ResponseEntity deleteServiceDoctorDetails(@RequestParam String serviceId, @RequestParam String doctorId){
        try{
            serviceDoctorDetailsRepository.deleteById(new ServiceDoctorDetailsPK(serviceId, doctorId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
