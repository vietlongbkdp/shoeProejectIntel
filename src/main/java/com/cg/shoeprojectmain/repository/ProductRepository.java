package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE (:category = 'all' OR p.category.nameCategory = :category) " +
            "AND (:minPrice <= p.prevPrice) " +
            "AND (:maxPrice > p.prevPrice) " +
            "AND (:color = 'all' OR p.color.nameColor = :color) " +
            "AND (:company = 'all' OR p.company.nameCompany = :company) " +
            "AND (LOWER(p.title) LIKE CONCAT('%', :search, '%'))")
    Page<Product> filterProduct(
            @Param("category") String category,
            @Param("company") String company,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("minPrice") BigDecimal minPrice,
            @Param("color") String color,
            @Param("search") String search,
            Pageable pageable);
}