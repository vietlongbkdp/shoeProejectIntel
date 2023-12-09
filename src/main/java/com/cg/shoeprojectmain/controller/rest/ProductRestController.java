package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.*;
import com.cg.shoeprojectmain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProduct(
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "maxPrice", required = false) Long maxPrice,
            @RequestParam(name = "minPrice", required = false) Long minPrice,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", required = false) int page,
            @RequestParam(name = "size", required = false) int size,
            @RequestParam(name = "sortField", required = false) String sortField,
            @RequestParam(name = "direction", required = false) String direction,
            Pageable pageable
    ){
            pageable = PageRequest.of(page, size, (direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC), sortField);
            Page<Product> products = productRepository.filterProduct(category, company, new BigDecimal(maxPrice), new BigDecimal(minPrice), color, search.toLowerCase(), pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
