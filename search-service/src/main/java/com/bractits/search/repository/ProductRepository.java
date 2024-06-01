package com.bractits.search.repository;

import com.bractits.search.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query,'%')) AND LOWER(p.description) LIKE LOWER(CONCAT('%', :query,'%'))")
    List<Product> search(@Param("query") String query);

    Optional<Product> findByProductId(Long productId);
    void deleteByProductId(Long productId);
}
