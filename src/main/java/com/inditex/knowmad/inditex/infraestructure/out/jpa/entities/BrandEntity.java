package com.inditex.knowmad.inditex.infraestructure.out.jpa.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Entidad que representa una Marca de la compañia
 */
@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity {

    @Id
    private Long id;

    private String name;


}

