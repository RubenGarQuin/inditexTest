package com.inditex.knowmad.inditex.application.service;

import com.inditex.knowmad.inditex.config.ExceptionMessages;
import com.inditex.knowmad.inditex.domain.exception.PriceNotFoundException;
import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.domain.port.in.PriceUseCase;
import com.inditex.knowmad.inditex.domain.port.out.PriceRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Servicio para el manejo de las operaciones relativas al model Price
 */
@Service
public class PriceService implements PriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public PriceService(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * Busca el precio a aplicar para un producto de una marca en una fecha concreta
     * @param date
     * @param productId
     * @param brandId
     * @return
     */
    @Override
    public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceRepositoryPort.findApplicablePrice(date,productId,brandId).
                orElseThrow( () -> new PriceNotFoundException(
                        ExceptionMessages.PRICE_NOT_FOUND.format(productId,brandId,date))
                );
    }
}
