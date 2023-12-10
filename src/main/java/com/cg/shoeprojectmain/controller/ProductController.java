package com.cg.shoeprojectmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {
    @GetMapping("")
    public String showProductPage(){
        return "/product/productPage";
    }
    @GetMapping("/management")
    public String showManagement(){
        return "/admin/productManagement";
    }
}
