package com.inditex.knowmad.inditex.infraestructure.out.jpa;

import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PriceId;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PricesEntity, PriceId> {
    @Query("select p from PricesEntity p where p.id.productId = :productId and p.id.brandId = :brandId "+
            "and :date between p.id.startDate and p.endDate order by p.priority desc")
    List<PricesEntity> findApplicablePrice(LocalDateTime date, Long productId , Long brandId);
}
