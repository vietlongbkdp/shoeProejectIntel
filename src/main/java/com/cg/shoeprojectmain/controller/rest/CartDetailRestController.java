package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.CartDetail;
import com.cg.shoeprojectmain.model.CustomerInfo;
import com.cg.shoeprojectmain.model.Product;
import com.cg.shoeprojectmain.model.dto.CartDetailCreDTO;
import com.cg.shoeprojectmain.repository.CartDetailRepository;
import com.cg.shoeprojectmain.repository.CartRepository;
import com.cg.shoeprojectmain.repository.CustomerInforRepossitory;
import com.cg.shoeprojectmain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartDetail")
public class CartDetailRestController {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerInforRepossitory customerInforRepossitory;
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
    @GetMapping
    public ResponseEntity<?> getAllCartDetail(){
        Long idUser = 1L;
        CustomerInfo customerInfo = customerInforRepossitory.findById(idUser).get();
        List<CartDetail> cartDetails = cartDetailRepository.findAllByCart_Id(customerInfo.getId());
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idCartDetail}")
    public ResponseEntity<?> deleteCartDetail(@PathVariable Long idCartDetail){
        cartDetailRepository.deleteById(idCartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/update/{idCartDetail}")
    public ResponseEntity<?> updateCartDetail(@PathVariable Long idCartDetail, @RequestParam Integer quantity){
            CartDetail cartDetail = cartDetailRepository.findById(idCartDetail).get();
            cartDetail.setQuantity(quantity);
            cartDetailRepository.save(cartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
