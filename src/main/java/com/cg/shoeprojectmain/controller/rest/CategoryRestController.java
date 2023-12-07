package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.Category;
import com.cg.shoeprojectmain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping
    public ResponseEntity<?> getAllCategory(){
        List<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
