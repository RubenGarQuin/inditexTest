package com.inditex.knowmad.inditex.domain.model;

import lombok.AllArgsConstructor;


/**
 * Modelo del negocio que representa una tarifa aplicable de precios.
 */
@AllArgsConstructor
public class PriceList {
    private final Long id;
    private final String name;
}
