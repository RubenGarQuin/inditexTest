package com.inditex.knowmad.inditex.infraestructure.out.jpa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 * Representa una tarifa que se puede aplicar a diferentes productos.
 */
@Entity
@Table(name = "Price_list")
@Getter
@Setter
public class PriceListEntity {

    @Id
    private Long id;

    private String description;
}
