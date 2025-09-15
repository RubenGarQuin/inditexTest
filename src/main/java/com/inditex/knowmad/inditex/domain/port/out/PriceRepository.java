package com.inditex.knowmad.inditex.domain.port.out;

import com.inditex.knowmad.inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findApplicablePrice(LocalDateTime date, Long productId , Long brandId);
}
