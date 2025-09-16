package com.inditex.knowmad.inditex.service;


import com.inditex.knowmad.inditex.application.service.PriceService;
import com.inditex.knowmad.inditex.domain.model.Price;
import com.inditex.knowmad.inditex.domain.port.out.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

public class PriceServiceTest {

    private PriceRepositoryPort priceRepositoryPort;
    private PriceService priceService;

    @BeforeEach
    void setup() {
        priceRepositoryPort = Mockito.mock(PriceRepositoryPort.class);
        priceService = new PriceService(priceRepositoryPort);
    }


    /**
     * Test unitario simple, comprobamos funcionalidad para caso basico.
     */
    @Test
    void testGetPriceFound() {
        Price price = new Price(null, null, null,
                LocalDateTime.now(), LocalDateTime.now().plusDays(30),
                0, new BigDecimal("35.50"), "EUR");

        Mockito.when(
                priceRepositoryPort.findApplicablePrice(any(), anyLong(), anyLong()))
                .thenReturn(Optional.of(price)
                );

        Price result = priceService.getPrice(LocalDateTime.now(), 35455L, 1L);
        assertNotNull(result);
        assertEquals(new BigDecimal("35.50"), result.getPrice());
    }


    /**
     * Test caso precio no existente para los parametros introducidos
     */
    @Test
    void testGetPriceNotFound() {

        Mockito.when(priceRepositoryPort.findApplicablePrice(any(), anyLong(), anyLong())).
                thenReturn(Optional.empty());

        var date = LocalDateTime.now();

        Exception exception = assertThrows(RuntimeException.class,
                () -> priceService.getPrice(date, 35455L, 1L)
            );

        assertTrue(exception.getMessage().contains("No se ha encontrado precio para el producto 35455 de la marca 1 en la fecha correspondiente (" +
                date+")"));
    }


}
