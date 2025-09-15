package com.inditex.knowmad.inditex.infraestructure.mapper;

import com.inditex.knowmad.inditex.domain.model.Product;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.ProductEntity;
import org.mapstruct.factory.Mappers;

public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toDomain(ProductEntity entity);
}
