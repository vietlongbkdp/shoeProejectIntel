package com.cg.shoeprojectmain.service.order;

import com.cg.shoeprojectmain.model.Order;
import com.cg.shoeprojectmain.service.IGeneralService;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderService extends IGeneralService<Order, Long> {
}
