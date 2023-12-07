package com.cg.shoeprojectmain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Filter {
    private Long companyId;
    private Long categoryId;
    private Long maxPrice;
    private Long minPrice;
    private Long colorId;
    private String search;
}
