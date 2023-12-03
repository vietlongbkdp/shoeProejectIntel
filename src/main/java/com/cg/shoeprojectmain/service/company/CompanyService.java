package com.cg.shoeprojectmain.service.company;

import com.cg.shoeprojectmain.model.Company;
import com.cg.shoeprojectmain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CompanyService implements ICompanyService{
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
