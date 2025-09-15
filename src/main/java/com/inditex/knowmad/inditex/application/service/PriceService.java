package com.inditex.knowmad.inditex.application.service;

import com.inditex.knowmad.inditex.domain.port.in.PriceUseCase;
import org.springframework.stereotype.Service;


@Service
public class PriceService implements PriceUseCase {



    @Override
    public void getPrice(String date, Long productId, Long brandId) {

    }
}
