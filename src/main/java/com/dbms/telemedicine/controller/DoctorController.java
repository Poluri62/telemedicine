package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.Doctor;
import com.dbms.telemedicine.model.Patient;
import com.dbms.telemedicine.repository.DoctorRepository;
import com.dbms.telemedicine.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/getDoctors")
    @ResponseBody
    public List<Doctor> getAllDoctors(){
        return StreamSupport.stream(doctorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getDoctorById/{id}")
    @ResponseBody
    public Doctor getDoctortById(@PathVariable String id){
        return doctorRepository.findById(id).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addDoctor")
    @ResponseBody
    public ResponseEntity addDoctor(@RequestBody Doctor doctor){
        try{
            Doctor doctorFromDb = doctorRepository.findById(doctor.getDoctorId()).stream().findFirst().orElse(null);
            if(doctorFromDb!=null){
                throw new DataIntegrityViolationException("Doctor with id already exists: Primary Key violation");
            }
            doctorRepository.save(doctor);
            //login
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @PostMapping("/updateDoctor")
    @ResponseBody
    public ResponseEntity updateDoctor(@RequestBody Doctor doctor){
        try{
            Doctor doctorFromDb = doctorRepository.findById(doctor.getDoctorId()).stream().findFirst().orElse(null);
            if(doctorFromDb==null){
                throw new Exception("Invalid Doctor Id");
            }
            doctorRepository.save(doctor);
            //login
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteDoctor/{id}")
    @ResponseBody
    public ResponseEntity deleteDoctorById(@PathVariable String id){
        try{
            doctorRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
