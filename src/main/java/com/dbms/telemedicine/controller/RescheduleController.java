package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
import com.dbms.telemedicine.model.CompositeKeys.ReschedulePK;
import com.dbms.telemedicine.model.Payment;
import com.dbms.telemedicine.model.Reschedule;
import com.dbms.telemedicine.repository.PaymentRepository;
import com.dbms.telemedicine.repository.RescheduleRepository;
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
@RequestMapping("/reschedule")
public class RescheduleController {

    @Autowired
    RescheduleRepository rescheduleRepository;

    @GetMapping("/getAllReschdules")
    @ResponseBody
    public List<Reschedule> getAllReschdules(){
        return StreamSupport.stream(rescheduleRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getReschduleByDoctorIdAndAppointmentId")
    @ResponseBody
    public Reschedule getReschduleByDoctorIdAndAppointmentId(@RequestParam String doctorId, @RequestParam String appointmentId){
        return rescheduleRepository.findById(new ReschedulePK(appointmentId, doctorId)).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addReschedule")
    @ResponseBody
    public ResponseEntity addReschedule(@RequestBody Reschedule reschedule){
        try{
            rescheduleRepository.save(reschedule);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Primary Key or Foreign Key Constraint violated");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insert Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteReschedule")
    @ResponseBody
    public ResponseEntity deletePayment(@RequestParam String doctorId, @RequestParam String appointmentId){
        try{
            rescheduleRepository.deleteById(new ReschedulePK(appointmentId, doctorId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
