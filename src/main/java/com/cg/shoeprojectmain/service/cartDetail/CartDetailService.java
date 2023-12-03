package com.cg.shoeprojectmain.service.cartDetail;

import com.cg.shoeprojectmain.model.CartDetail;
import com.cg.shoeprojectmain.repository.CartDetailRepository;
import com.cg.shoeprojectmain.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CartDetailService implements ICartDetailService{
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Override
    public List<CartDetail> findAll() {
        return cartDetailRepository.findAll();
    }

    @Override
    public Optional<CartDetail> findById(Long id) {
        return cartDetailRepository.findById(id);
    }

    @Override
    public void save(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void deleteById(Long id) {

    }
}
