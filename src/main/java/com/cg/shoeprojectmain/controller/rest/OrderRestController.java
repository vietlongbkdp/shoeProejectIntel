package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.*;
import com.cg.shoeprojectmain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@Transactional
public class OrderRestController {
    @Autowired
    private CustomerInforRepossitory customerInforRepossitory;
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody CustomerInfo customerInfo) {
        Long idUser = customerInfo.getId();
        CustomerInfo customer = customerInforRepossitory.findById(idUser).get();
        customer.setFullName(customerInfo.getFullName()).setEmail(customerInfo.getEmail())
                .setAddress(customerInfo.getAddress())
                .setMobile(customerInfo.getMobile());
        customerInforRepossitory.save(customer);
        Cart cart = cartRepository.findCartByCustomerInfo_Id(idUser);
        BigDecimal totalAmount = cartDetailRepository.getTotalAmountCart(cart.getId());
        Order order = new Order().setCustomerInfo(customerInforRepossitory.findById(idUser).get())
                .setTotalAmount(totalAmount).setCustomerName(customerInforRepossitory.findById(idUser).get().getFullName())
                .setAddress(customerInforRepossitory.findById(idUser).get().getAddress())
                        .setPhone(customerInforRepossitory.findById(idUser).get().getMobile());
        orderRepository.save(order);
        List<CartDetail> cartDetails = cartDetailRepository.findAllByCart_Id(cart.getId());
        for (CartDetail cd: cartDetails) {
            OrderDetail orderDetail = new OrderDetail().setOrder(order)
                    .setProduct(cd.getProduct()).setQuantity(cd.getQuantity()).setProductName(cd.getProduct().getTitle())
                    .setPricePresent(cd.getProduct().getNewPrice());
            orderDetailRepository.save(orderDetail);
            cartDetailRepository.delete(cd);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
