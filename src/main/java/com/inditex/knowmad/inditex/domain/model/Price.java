package com.inditex.knowmad.inditex.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Modelo del negocio que representa el precio de un articulo en determinada fecha y su tarifa
 */
@AllArgsConstructor
@Getter
public class Price {

    private final Brand brandId;
    private final Product productId;
    private final PriceList priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priority;
    private final BigDecimal price;
    private final String currency;

}


