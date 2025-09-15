package com.inditex.knowmad.inditex.domain.port.in;

import com.inditex.knowmad.inditex.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceUseCase {

    Price getPrice(LocalDateTime date, Long productId, Long brandId);

}
