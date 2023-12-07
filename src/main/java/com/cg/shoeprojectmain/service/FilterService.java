package com.cg.shoeprojectmain.service;

import com.cg.shoeprojectmain.model.Category;
import com.cg.shoeprojectmain.model.Color;
import com.cg.shoeprojectmain.model.Company;
import com.cg.shoeprojectmain.model.Filter;
import com.cg.shoeprojectmain.model.dto.FilterDTO;
import com.cg.shoeprojectmain.repository.CategoryRepository;
import com.cg.shoeprojectmain.repository.ColorRepository;
import com.cg.shoeprojectmain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public Filter toFilter(FilterDTO filterDTO){
        Color colors = colorRepository.getColorByNameColor(filterDTO.getColor());
        Category categorys = categoryRepository.getCategoryByNameCategory(filterDTO.getCategory());
        Company companys = companyRepository.getCompanyByNameCompany(filterDTO.getCompany());
        Filter filters = new Filter().setSearch(filterDTO.getSearch()).setMinPrice(filterDTO.getMinPrice()).setMaxPrice(filterDTO.getMaxPrice())
                .setColorId(colors.getId()).setCompanyId(companys.getId()).setCategoryId(categorys.getId());
        return filters;
    }
}
