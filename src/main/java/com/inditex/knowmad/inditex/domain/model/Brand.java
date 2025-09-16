package com.inditex.knowmad.inditex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Modelo del negocio que representa una marca de la compañia
 */
@AllArgsConstructor
@Getter
public class Brand {
    private final Long brandId;
    private final String name;
}
