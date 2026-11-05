package org.example.pmapi.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.example.pmapi.dto.DresseurDTO;
import org.example.pmapi.services.DresseurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(controllers = DresseurController.class)
public class DresseurControllerTest {

    @MockitoBean
    private DresseurService dresseurService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_200_when_get_dresseur_by_id_has_dresseur() throws Exception {

        // Arrange
        DresseurDTO dresseur = new DresseurDTO("Sacha", 4, 250);
        when(dresseurService.get(1L)).thenReturn(dresseur);

        // Act et assert
        mockMvc.perform(get("/dresseurs/id").param("id", "1"))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_204_when_get_dresseur_by_id_has_no_dresseur() throws Exception {
        // Arrange
        when(dresseurService.get(1L))
                .thenThrow(new EntityNotFoundException("Dresseur introuvable avec l'id : " + 1L));

        // Act et assert
        mockMvc.perform(get("/dresseurs/id")
                .param("id", "1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void should_return_500_when_get_dresseur_by_id_has_other_error() throws Exception {
        // Arrange
        when(dresseurService.get(1L))
                .thenThrow(new RuntimeException("Erreur interne"));

        // Act et assert
        mockMvc.perform(get("/dresseurs/id")
                        .param("id", "1"))
                .andExpect(status().isInternalServerError());
    }
}
