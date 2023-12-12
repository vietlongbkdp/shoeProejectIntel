package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.CustomerInfo;
import com.cg.shoeprojectmain.repository.CustomerInforRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customerInfo")
public class CustomerInfoRestController {
    @Autowired
    private CustomerInforRepossitory customerInforRepossitory;
    @GetMapping
    public ResponseEntity<?> findCustomerPresent(){
        Long idUser = 1L;
        CustomerInfo customerInfo = customerInforRepossitory.findById(idUser).get();
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }
}
