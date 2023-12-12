package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    boolean existsByProduct_Id(Long idProduct);
    CartDetail getCartDetailByProduct_Id(Long idProduct);
    List<CartDetail> findAllByCart_Id(Long idCart);
    @Query("SELECT SUM(cd.amount*cd.quantity) FROM CartDetail cd WHERE cd.cart.id = :idCart")
    BigDecimal getTotalAmountCart(@Param("idCart") Long idCart);

}
