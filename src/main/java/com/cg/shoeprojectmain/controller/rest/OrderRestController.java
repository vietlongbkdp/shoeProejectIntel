package com.cg.shoeprojectmain.controller.rest;

import com.cg.shoeprojectmain.model.*;
import com.cg.shoeprojectmain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<?> getAllOrderByUser(){
        Long idUser =1L;
        List<Order> orders = orderRepository.findAllByCustomerInfo_Id(idUser);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{idOrder}")
    public ResponseEntity<?> countOrderDetailByIdOrder(@PathVariable Long idOrder){
            List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrder_Id(idOrder);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
    @GetMapping("/getOrder/{idOrder}")
    public ResponseEntity<?> getOrderPresent(@PathVariable Long idOrder){
        Order order = orderRepository.findById(idOrder).get();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
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
