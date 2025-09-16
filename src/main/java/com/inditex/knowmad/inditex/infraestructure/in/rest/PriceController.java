package com.inditex.knowmad.inditex.infraestructure.in.rest;


import com.inditex.knowmad.inditex.domain.port.in.PriceUseCase;
import com.inditex.knowmad.inditex.infraestructure.mapper.PriceMapper;
import com.inditex.knowmad.inditex.infraestructure.out.dto.PriceResponseDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Controller Api Price
 */
@RestController
@RequestMapping("prices")
@Validated
public class PriceController {


    private final PriceUseCase priceUseCase;
    private final PriceMapper priceMapper;

    public PriceController(PriceUseCase priceUseCase, PriceMapper priceMapper) {
        this.priceUseCase = priceUseCase;
        this.priceMapper = priceMapper;
    }


    /**
     *
     * @param date
     * @param productId
     * @param brandId
     * @return PriceResponseDto, dto con la informacion del precio de un producto y la
     * tarifa aplicada en una fecha concreta
     */
    @GetMapping
    public ResponseEntity<PriceResponseDto> getPrice(
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                                     @RequestParam(required = true)  Long productId,
                                                     @RequestParam(required = true)   Long brandId){
        var price = priceUseCase.getPrice(date, productId, brandId);
        return ResponseEntity.ok(priceMapper.toDto(price));
    }
}
