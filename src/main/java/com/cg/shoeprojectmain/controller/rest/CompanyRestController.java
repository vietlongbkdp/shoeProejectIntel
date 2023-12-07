package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.Company;
import com.cg.shoeprojectmain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyRestController {
    @Autowired
    private CompanyRepository companyRepository;
    @GetMapping
    public ResponseEntity<?> getAllCompany(){
        List<Company> companies = companyRepository.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
}
