package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    boolean existsByProduct_Id(Long idProduct);
    CartDetail getCartDetailByProduct_Id(Long idProduct);
}
