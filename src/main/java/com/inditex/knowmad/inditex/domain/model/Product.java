package com.inditex.knowmad.inditex.domain.model;


import lombok.AllArgsConstructor;


/**
 * Modelo del negocio que representa un producto de la compañia.
 */
@AllArgsConstructor
public class Product {
    private final Long productId;
    private final String name;
}
