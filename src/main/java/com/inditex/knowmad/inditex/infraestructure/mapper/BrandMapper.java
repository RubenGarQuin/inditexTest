package com.inditex.knowmad.inditex.infraestructure.mapper;


import com.inditex.knowmad.inditex.domain.model.Brand;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


/**
 * Clase para el mapeo de modelos de dominio y entidades jpa
 * From entity to Domain
 * From domain to ResponseDto
 */

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "brandId")
    Brand toDomain(BrandEntity entity);

}
