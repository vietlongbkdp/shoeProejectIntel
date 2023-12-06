package com.cg.shoeprojectmain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    private String brand;
    private String category;
    private Long priceMax;
    private Long priceMin;
    private String color;
    private String search;
}
