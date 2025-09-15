package com.inditex.knowmad.inditex.infraestructure.out.jpa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * Representa un producto de la compañia.
 */
@Entity
@Table(name = "product")
@Data
public class ProductEntity {

    @Id
    private Long id;

    private String name;
}
