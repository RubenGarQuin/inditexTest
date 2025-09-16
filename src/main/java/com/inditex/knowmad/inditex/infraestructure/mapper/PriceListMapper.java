package com.inditex.knowmad.inditex.infraestructure.mapper;

import com.inditex.knowmad.inditex.domain.model.PriceList;
import com.inditex.knowmad.inditex.infraestructure.out.dto.PriceListResponseDto;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PriceListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceListMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    PriceList toDomain(PriceListEntity entity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    PriceListResponseDto toDto(PriceList priceList);

}
