package com.inditex.knowmad.inditex.infraestructure.mapper;

import com.inditex.knowmad.inditex.domain.model.PriceList;
import com.inditex.knowmad.inditex.infraestructure.out.dto.PriceListResponseDto;
import com.inditex.knowmad.inditex.infraestructure.out.jpa.entities.PriceListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceListMapper {

    PriceListMapper INSTANCE = Mappers.getMapper(PriceListMapper.class);

    PriceList toDomain(PriceListEntity entity);

    PriceListResponseDto toDto(PriceList priceList);

}
