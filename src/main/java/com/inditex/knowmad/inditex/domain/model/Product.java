package com.inditex.knowmad.inditex.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Modelo del negocio que representa un producto de la compañia.
 */
@AllArgsConstructor
@Getter
public class Product {
    private final Long productId;
    private final String name;
}
