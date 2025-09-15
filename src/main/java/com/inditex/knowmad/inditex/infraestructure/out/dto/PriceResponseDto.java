package com.inditex.knowmad.inditex.infraestructure.out.dto;


import lombok.Data;

@Data
public class PriceResponseDto {

    private Long productId;
    private Long brandId;
    private PriceListResponseDto priceList;
    private String startDate;
    private String endDate;
    private String price;



    /**
     * identificador de producto, identificador de cadena, tarifa a aplicar,
     * fechas de aplicación y precio final a aplicar
     */
}
