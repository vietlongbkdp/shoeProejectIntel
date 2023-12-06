package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.Filter;
import com.cg.shoeprojectmain.model.Product;
import com.cg.shoeprojectmain.repository.ProductRepository;
import com.cg.shoeprojectmain.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("")
    public ResponseEntity<?> getAllProduct(@RequestBody Filter filter){
        List<Product> products = productRepository.findAllByFilter(filter.getBrand(), filter.getColor(), filter.getCategory(), filter.getPriceMax(), filter.getPriceMin(), filter.getSearch());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
