package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.AppointmentDetails;
import com.dbms.telemedicine.model.CompositeKeys.AppointmentDetailsPK;
import com.dbms.telemedicine.model.CompositeKeys.ServiceDoctorDetailsPK;
import com.dbms.telemedicine.model.ServiceDoctorDetails;
import com.dbms.telemedicine.repository.AppointmentDetailsRepository;
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
@RequestMapping("/appointmentDetails")
public class AppointmentDetailsController {

    @Autowired
    AppointmentDetailsRepository appointmentDetailsRepository;

    @GetMapping("/getAllAppointmentDetails")
    @ResponseBody
    public List<AppointmentDetails> getAllAppointmentDetails(){
        return StreamSupport.stream(appointmentDetailsRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getAllAppointmentDetailsByPatientId/{patientId}")
    @ResponseBody
    public List<AppointmentDetails> getAllAppointmentDetailsByPatientId(@PathVariable String patientId){
        return appointmentDetailsRepository.getAllByPatientId(patientId);
    }

    @GetMapping("/getAllAppointmentDetailsByDoctorId/{doctorId}")
    @ResponseBody
    public List<AppointmentDetails> getAllSAppointmentDetailsByDoctorId(@PathVariable String doctorId){
        return appointmentDetailsRepository.getAllByDoctorId(doctorId);
    }

    @PostMapping("/addAppointmentDetails")
    @ResponseBody
    public ResponseEntity addAppointmentDetails(@RequestBody AppointmentDetails appointmentDetails){
        try{
            appointmentDetailsRepository.save(appointmentDetails);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Foreign Key Constraint violated: Doctor Id, Service Id or Patient Id does not exist");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteAppointmentDetails")
    @ResponseBody
    public ResponseEntity deleteAppointmentDetails(@RequestParam String appointmentId, @RequestParam String serviceId,@RequestParam String patientId, @RequestParam String doctorId){
        try{
            appointmentDetailsRepository.deleteById(new AppointmentDetailsPK(appointmentId, serviceId, patientId, doctorId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
