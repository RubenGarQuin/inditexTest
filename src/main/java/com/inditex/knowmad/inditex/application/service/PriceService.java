package com.inditex.knowmad.inditex.application.service;

import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.domain.port.in.PriceUseCase;
import com.inditex.knowmad.inditex.domain.port.out.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class PriceService implements PriceUseCase {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
        var price = priceRepository.findApplicablePrice(date,productId,brandId);
        return price.get();
    }
}
