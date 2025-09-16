package com.inditex.knowmad.inditex.infraestructure.mapper;


import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.infraestructure.out.dto.PriceResponseDto;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/**
 * Clase para el mapeo de modelos de dominio y entidades jpa
 * From entity to Domain
 * From domain to ResponseDto
 */
@Mapper(componentModel = "spring", uses = { BrandMapper.class, ProductMapper.class, PriceListMapper.class })
public interface PriceMapper {

    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "id.startDate", target = "startDate")
    Price toDomain(PricesEntity entity);

    @Mapping(target = "productId", expression = "java(price.getProduct().getProductId())")
    @Mapping(target = "brandId", expression = "java(price.getBrand().getBrandId())")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(target = "startDate", expression = "java(price.getStartDate().toString())")
    @Mapping(target = "endDate", expression = "java(price.getEndDate().toString())")
    @Mapping(target = "price", expression = "java(price.getPrice().toString() +' '+ price.getCurrency())")
    PriceResponseDto toDto(Price price);
}
