package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.Color;
import com.cg.shoeprojectmain.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorRestController {
    @Autowired
    private ColorRepository colorRepository;
    @GetMapping
    public ResponseEntity<?> getAllColor(){
        List<Color> colors = colorRepository.findAll();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }
}
