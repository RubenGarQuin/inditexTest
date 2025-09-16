package com.inditex.knowmad.inditex.infraestructure.out.jpa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;



/**
 * Identificador compuesto para la tabla Prices.
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceId implements Serializable {

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "price_list")
    private Long priceListId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceId)) return false;
        PriceId that = (PriceId) o;
        return Objects.equals(brandId, that.brandId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(priceListId, that.priceListId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, productId, startDate, priceListId);
    }

}

