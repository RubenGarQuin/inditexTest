package com.inditex.knowmad.inditex.infraestructure.out.jpa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Representa el precio final y la tarifa a aplicar para un producto de una cadena
 * en una fecha determinada
 */

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Prices")
public class PricesEntity {

    @EmbeddedId
    private PriceId id;

    private LocalDateTime endDate;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String currency;

    /**
     * Relación many to one donde relacionamos ambas entidades por el id de brandId
     * Al ser parte de la primaryKey no puede ser nulo
     */
    @ManyToOne
    @MapsId("brandId")
    @JoinColumn(
            name = "brand_id",
            nullable = false
    )
    private BrandEntity brand;


    @ManyToOne
    @MapsId("priceListId")
    @JoinColumn(
            name = "price_list",
            nullable = false
    )
    private PriceListEntity priceList;


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(
            name = "product_id",
            nullable = false
    )
    private ProductEntity product;
}
