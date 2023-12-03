package com.cg.shoeprojectmain.service.customerInfo;

import com.cg.shoeprojectmain.model.CustomerInfo;
import com.cg.shoeprojectmain.repository.CustomerInforRepossitory;
import com.cg.shoeprojectmain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CustomerInforService implements ICustomerInforService{
    @Autowired
    private CustomerInforRepossitory customerInforRepossitory;
    @Override
    public List<CustomerInfo> findAll() {
        return customerInforRepossitory.findAll();
    }

    @Override
    public Optional<CustomerInfo> findById(Long id) {
        return customerInforRepossitory.findById(id);
    }

    @Override
    public void save(CustomerInfo customerInfo) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
