package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.CartDetail;
import com.cg.shoeprojectmain.model.Product;
import com.cg.shoeprojectmain.model.dto.CartDetailCreDTO;
import com.cg.shoeprojectmain.repository.CartDetailRepository;
import com.cg.shoeprojectmain.repository.CartRepository;
import com.cg.shoeprojectmain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartDetail")
public class CartDetailRestController {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @PostMapping
    public ResponseEntity<?> createCartDetail(@RequestBody CartDetailCreDTO cartDetailCreDTO){
        Product product = productRepository.findById(cartDetailCreDTO.getIdProduct()).get();
        if (cartDetailRepository.existsByProduct_Id(cartDetailCreDTO.getIdProduct())){
            CartDetail cartDetail = cartDetailRepository.getCartDetailByProduct_Id(cartDetailCreDTO.getIdProduct());
            Integer quantityNew = cartDetail.getQuantity() +1;
            cartDetail.setQuantity(quantityNew);
            cartDetailRepository.save(cartDetail);
        }else{
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cartRepository.findById(1L).get())
                    .setQuantity(1).setProduct(product).setAmount(product.getNewPrice());
            cartDetailRepository.save(cartDetail);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
