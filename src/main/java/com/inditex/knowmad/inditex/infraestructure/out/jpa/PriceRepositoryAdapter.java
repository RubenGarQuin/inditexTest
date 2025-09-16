package com.inditex.knowmad.inditex.infraestructure.out.jpa;

import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.domain.port.out.PriceRepositoryPort;
import com.inditex.knowmad.inditex.infraestructure.mapper.PriceMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * Adapter de la interfaz de salida del dominio para conexiones a la base de datos
 */
@Repository
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    public PriceRepositoryAdapter(PriceJpaRepository priceJpaRepository, PriceMapper priceMapper) {
        this.priceJpaRepository = priceJpaRepository;
        this.priceMapper = priceMapper;
    }


    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime date, Long productId, Long brandId) {
        return priceJpaRepository.findApplicablePrice(date,productId,brandId).stream().
                findFirst().map(priceMapper::toDomain);
    }
}
