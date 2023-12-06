package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "Select * FROM products WHERE color = : color", nativeQuery = true)
    List<Product> findAllByFilter(@Param("color") String color);
}
