package com.inditex.knowmad.inditex.domain.port.in;

import com.inditex.knowmad.inditex.domain.model.Price;

public interface PriceUseCase {

    Price getPrice(String date, Long productId, Long brandId);

}
