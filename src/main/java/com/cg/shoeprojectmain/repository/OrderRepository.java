package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCustomerInfo_Id(Long customerId);
    List<Order> findAllByCustomerInfo_Id(Long customerInfoId);
}
