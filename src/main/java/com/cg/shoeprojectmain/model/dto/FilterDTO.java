package com.cg.shoeprojectmain.model.dto;

import com.cg.shoeprojectmain.model.Category;
import com.cg.shoeprojectmain.model.Color;
import com.cg.shoeprojectmain.model.Company;
import com.cg.shoeprojectmain.model.Filter;
import com.cg.shoeprojectmain.repository.CategoryRepository;
import com.cg.shoeprojectmain.repository.ColorRepository;
import com.cg.shoeprojectmain.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FilterDTO {
    private String company;
    private String category;
    private Long maxPrice;
    private Long minPrice;
    private String color;
    private String search;
}
