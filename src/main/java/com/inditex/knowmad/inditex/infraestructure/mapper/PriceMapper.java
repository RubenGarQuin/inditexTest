package com.inditex.knowmad.inditex.infraestructure.mapper;


import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * Clase para el mapeo de modelos de dominio y entidades jpa
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);


    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "priceList.id", target = "priceList")
    @Mapping(source = "id.startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "currency", target = "currency")
    Price toDomain(PricesEntity entity);
}
