package com.inditex.knowmad.inditex.infraestructure.mapper;


import com.inditex.knowmad.inditex.domain.model.Brand;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * Clase para el mapeo de modelos de dominio y entidades jpa
 * From entity to Domain
 * From domain to ResponseDto
 */

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toDomain(BrandEntity entity);
}
