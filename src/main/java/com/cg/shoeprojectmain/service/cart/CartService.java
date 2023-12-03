package com.cg.shoeprojectmain.service.cart;

import com.cg.shoeprojectmain.model.Cart;
import com.cg.shoeprojectmain.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CartService implements ICartService{
    @Autowired
    private CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
