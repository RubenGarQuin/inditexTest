package com.inditex.knowmad.inditex.infraestructure.out.jpa;

import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PriceId;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJpaRepository extends JpaRepository<PricesEntity, PriceId> {
    @Query("select p from PricesEntity p WHERE p.id.productId = :productId AND p.id.brandId = :brandId "+
            "AND :date BETWEEN p.id.startDate AND p.endDate")
    Optional<PricesEntity> findApplicablePrice(LocalDateTime date, Long productId , Long brandId);
}
