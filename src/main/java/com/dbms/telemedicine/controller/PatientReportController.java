package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.CompositeKeys.PatientReportPK;
import com.dbms.telemedicine.model.PatientReport;
import com.dbms.telemedicine.repository.PatientReportRepository;
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
@RequestMapping("/patientReport")
public class PatientReportController {

    @Autowired
    PatientReportRepository patientReportRepository;

    @GetMapping("/getAllReports")
    @ResponseBody
    public List<PatientReport> getAllPatientReports(){
        return StreamSupport.stream(patientReportRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getReportsByPatientId/{patientId}")
    @ResponseBody
    public List<PatientReport> getPatientReportsById(@PathVariable String patientId){
        return patientReportRepository.getAllByPatientId(patientId);
    }

    @PostMapping("/addReport")
    @ResponseBody
    public ResponseEntity addPatientReport(@RequestBody PatientReport patientReport){
        try{
            patientReportRepository.save(patientReport);
            //login
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Foreign Key Constraint violated: Patient Id does not exist");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteReport")
    @ResponseBody
    public ResponseEntity deletePatientById(@RequestParam String patientId, @RequestParam String patientReportId){
        try{
            patientReportRepository.deleteById(new PatientReportPK(patientId, patientReportId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
