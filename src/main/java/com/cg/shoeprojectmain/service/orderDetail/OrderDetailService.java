package com.cg.shoeprojectmain.service.orderDetail;

import com.cg.shoeprojectmain.model.OrderDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class OrderDetailService implements IOrderDetail {
    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(OrderDetail orderDetail) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
