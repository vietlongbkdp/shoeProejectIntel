package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.*;
import com.cg.shoeprojectmain.model.dto.FilterDTO;
import com.cg.shoeprojectmain.repository.ProductRepository;
import com.cg.shoeprojectmain.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FilterService filterService;
    @PostMapping
    public ResponseEntity<?> getAllProduct(@RequestBody FilterDTO filterDTO){
            Filter filter = filterService.toFilter(filterDTO);
            List<Product> products = productRepository.filterProduct(filter);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
