package com.inditex.knowmad.inditex.infraestructure.mapper;

import com.inditex.knowmad.inditex.domain.model.Product;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/**
 * Clase para el mapeo de modelos de dominio y entidades jpa
 * From entity to Domain
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "productId")
    Product toDomain(ProductEntity entity);
}
