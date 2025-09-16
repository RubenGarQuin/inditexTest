package com.inditex.knowmad.inditex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Modelo del negocio que representa una tarifa aplicable de precios.
 */
@AllArgsConstructor
@Getter
public class PriceList {
    private final Long id;
    private final String name;
}
