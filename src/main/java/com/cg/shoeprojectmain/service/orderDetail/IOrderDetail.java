package com.cg.shoeprojectmain.service.orderDetail;

import com.cg.shoeprojectmain.model.OrderDetail;
import com.cg.shoeprojectmain.service.IGeneralService;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetail extends IGeneralService<OrderDetail, Long> {
}
