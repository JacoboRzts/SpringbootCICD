package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest; // <- nuevo paquete
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HolaController.class)
class HolaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saludaPorDefecto() throws Exception {
        mockMvc.perform(get("/hola"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola, mundo!"));
    }

    @Test
    void saludaConNombre() throws Exception {
        mockMvc.perform(get("/hola").param("nombre", "Ana"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola, Ana!"));
    }
}
