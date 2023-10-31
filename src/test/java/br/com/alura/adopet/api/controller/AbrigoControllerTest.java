package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.service.AbrigoService;
import br.com.alura.adopet.api.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(AbrigoController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = AbrigoController.class)
public class AbrigoControllerTest {

    @InjectMocks
    private AbrigoController abrigoController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AbrigoService abrigoService;

    @MockBean
    private PetService petService;

    @Test
    void testListarAbrigoSucesso() throws Exception {
        var abrigos = abrigoService.listar();
        when(abrigoService.listar()).thenReturn(abrigos);

        mockMvc.perform(
                    get("/abrigos")
                )
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                );

    }

}
