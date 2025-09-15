package com.inditex.knowmad.inditex.domain.model;

import lombok.AllArgsConstructor;


/**
 * Modelo del negocio que representa una marca de la compañia
 */
@AllArgsConstructor
public class Brand {
    private final Long brandId;
    private final String name;
}
