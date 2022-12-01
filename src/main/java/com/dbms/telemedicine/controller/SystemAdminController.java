package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.Patient;
import com.dbms.telemedicine.model.SystemAdmin;
import com.dbms.telemedicine.repository.PatientRepository;
import com.dbms.telemedicine.repository.SystemAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class SystemAdminController {

    @Autowired
    SystemAdminRepository systemAdminRepository;

    @GetMapping("/getAdmins")
    @ResponseBody
    public List<SystemAdmin> getAdmins(){
        return StreamSupport.stream(systemAdminRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getAdminById")
    @ResponseBody
    public SystemAdmin getAdminById(@RequestParam String id){
        return systemAdminRepository.findById(id).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addAdmin")
    @ResponseBody
    public ResponseEntity addAdmin(@RequestBody SystemAdmin systemAdmin){
        try{
            systemAdminRepository.save(systemAdmin);
            //login
        } catch(Exception e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteAdmin")
    @ResponseBody
    public ResponseEntity deleteAdmin(@RequestParam String id){
        try{
            systemAdminRepository.deleteById(id);
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
