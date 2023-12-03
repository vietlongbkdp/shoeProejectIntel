package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInforRepossitory extends JpaRepository<CustomerInfo, Long> {
}
