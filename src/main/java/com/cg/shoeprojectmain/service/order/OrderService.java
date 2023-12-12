package com.cg.shoeprojectmain.service.order;

import com.cg.shoeprojectmain.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService implements IOrderService {
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
