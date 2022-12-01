package com.dbms.telemedicine.controller;

import com.dbms.telemedicine.model.AppointmentDetails;
import com.dbms.telemedicine.model.CompositeKeys.AppointmentDetailsPK;
import com.dbms.telemedicine.model.CompositeKeys.PaymentPK;
import com.dbms.telemedicine.model.Payment;
import com.dbms.telemedicine.repository.AppointmentDetailsRepository;
import com.dbms.telemedicine.repository.PaymentRepository;
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
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/getAllPayments")
    @ResponseBody
    public List<Payment> getAllPayments(){
        return StreamSupport.stream(paymentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/getPaymentByPaymentIdAndAppointmentId")
    @ResponseBody
    public Payment getPaymentByPaymentIdAndAppointmentId(@RequestParam String paymentId, @RequestParam String appointmentId){
        return paymentRepository.findById(new PaymentPK(paymentId, appointmentId)).stream().findFirst().orElseThrow();
    }

    @PostMapping("/addPayment")
    @ResponseBody
    public ResponseEntity addPayment(@RequestBody Payment payment){
        try{
            paymentRepository.save(payment);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Foreign Key Constraint violated: Appointment Id does not exist");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }

        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deletePayment")
    @ResponseBody
    public ResponseEntity deletePayment(@RequestParam String paymentId, @RequestParam String appointmentId){
        try{
            paymentRepository.deleteById(new PaymentPK(paymentId, appointmentId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
        }
        return ResponseEntity.ok().body("Delete Successful");
    }
}
