package com.inditex.knowmad.inditex.infraestructure.mapper;


import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.infraestructure.out.dto.PriceResponseDto;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * Clase para el mapeo de modelos de dominio y entidades jpa
 * From entity to Domain
 * From domain to ResponseDto
 */
@Mapper(componentModel = "spring", uses = { BrandMapper.class, ProductMapper.class, PriceListMapper.class })
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);


    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "id.startDate", target = "startDate")
    Price toDomain(PricesEntity entity);

    @Mapping(source = "product", target = "productId", qualifiedByName = "mapProductId")
    @Mapping(source = "brand.id", target = "brandId", qualifiedByName = "mapBrandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(target = "startDate", expression = "java(price.getStartDate().toString())")
    @Mapping(target = "endDate", expression = "java(price.getEndDate().toString())")
    @Mapping(target = "price", expression = "java(price.getPrice().toString())")
    PriceResponseDto toDto(Price price);
}
