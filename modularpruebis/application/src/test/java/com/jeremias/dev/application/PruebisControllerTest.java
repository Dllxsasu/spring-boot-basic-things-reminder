package com.jeremias.dev.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(PruebisController.class)
public class PruebisControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("pruebbita message loki ")
    public void lokiMessage()  throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/prueba"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hasta la vista baby"));

    }
}
