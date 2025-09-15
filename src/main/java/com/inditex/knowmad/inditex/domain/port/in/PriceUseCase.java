package com.inditex.knowmad.inditex.domain.port.in;

public interface PriceUseCase {

    void getPrice(String date,Long productId, Long brandId);

}
