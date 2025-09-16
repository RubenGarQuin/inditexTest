package com.inditex.knowmad.inditex.infraestructure;


import com.inditex.knowmad.inditex.infraestructure.out.jpa.PriceJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests de integracion para el controller de la API.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceJpaRepository repository;


    /**
     * Test de caso ideal donde existe el precio buscado
     */
    @Test
    void testGetPriceEndpoint() throws Exception {

        mockMvc.perform(get("/prices")
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value("35.50 EUR"));
    }



    /**
     * Test de caso no existe precio para los parametros pasados
     */
    @Test
    void testGetPriceNotFound() throws Exception {

        mockMvc.perform(get("/prices")
                        .param("date", "2050-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.Error").exists())
                .andExpect(jsonPath("$.Error").value(
                        "No se ha encontrado precio para el producto 35455 de la marca 1 en la fecha correspondiente (2050-06-14T10:00)"))
                .andExpect(jsonPath("$.code").value(404))
        ;
    }



    /**
     * Test caso no se envian todos los parametros requeridos
     */
    @Test
    void testGetPriceEndpointMissingParam() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.Error").exists())
                .andExpect(jsonPath("$.code").value(400));
    }


}
