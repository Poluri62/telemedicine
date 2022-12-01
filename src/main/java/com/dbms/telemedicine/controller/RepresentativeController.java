package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
import com.dbms.telemedicine.model.CompositeKeys.RepresentativePK;
import com.dbms.telemedicine.model.Payment;
import com.dbms.telemedicine.model.Representative;
import com.dbms.telemedicine.repository.PaymentRepository;
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
@RequestMapping("/representative")
public class RepresentativeController {

    @Autowired
    RepresentativeRepository representativeRepository;

    @GetMapping("/getAllRepresentatives")
    @ResponseBody
    public List<Representative> getAllRepresentatives(){
        return StreamSupport.stream(representativeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getRepresentativeByRepresentativeIdAndPatientId")
    @ResponseBody
    public Representative getRepresentativeByRepresentativeIdAndPatientId(@RequestParam String representativeId, @RequestParam String patientId){
        return representativeRepository.findById(new RepresentativePK(representativeId, patientId)).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addRepresentative")
    @ResponseBody
    public ResponseEntity addRepresentative(@RequestBody Representative representative){
        try{
            representativeRepository.save(representative);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data Integrity violated");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteRepresentative")
    @ResponseBody
    public ResponseEntity deletePayment(@RequestParam String representativId, @RequestParam String patientId){
        try{
            representativeRepository.deleteById(new RepresentativePK(representativId, patientId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
