package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company getCompanyByNameCompany(String companyName);
}
