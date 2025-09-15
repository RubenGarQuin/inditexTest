package com.inditex.knowmad.inditex.infraestructure.in.rest;


import com.inditex.knowmad.inditex.domain.port.in.PriceUseCase;
import com.inditex.knowmad.inditex.infraestructure.out.dto.PriceResponseDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController("Price")
public class PriceController {


    private final PriceUseCase priceUseCase;

    public PriceController(PriceUseCase priceUseCase) {
        this.priceUseCase = priceUseCase;
    }

    @GetMapping
    public ResponseEntity<PriceResponseDto> getPrice(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                                     @PathVariable Long productId,
                                                     @PathVariable Long brandId){
        priceUseCase.getPrice(date, productId, brandId);
        return ResponseEntity.ok(null);
    }
}
