package com.cg.shoeprojectmain.repository;

import com.cg.shoeprojectmain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products\n" +
            "where title like %:search%\n" +
            "and (:color is null or color_id = :color)\n" +
            "and (:brand null or company_id = :brand)\n" +
            "and (:category is null or category_id = :category)\n" +
            "and (:priceMin is null or new_price > :priceMin)\n" +
            "and (:priceMax is null or new_price < :priceMax)", nativeQuery = true)
    List<Product> findAllByFilter(@Param("search") String search,@Param("color") String color,@Param("brand") String brand,@Param("category") String category,@Param("priceMax") Long priceMax,@Param("priceMin") Long priceMin);
}