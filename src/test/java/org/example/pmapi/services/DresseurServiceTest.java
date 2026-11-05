package org.example.pmapi.services;

import org.example.pmapi.entities.DresseurEntity;
import org.example.pmapi.entities.PokemonEntity;
import org.example.pmapi.repositories.DresseurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DresseurServiceTest {

    @Mock
    private DresseurRepository dresseurRepository;

    @InjectMocks
    private DresseurService dresseurService;

    private DresseurEntity dresseurNoPokemons;
    private DresseurEntity dresseurPokemons;

    @BeforeEach
    void init() {
        // Arrange
        dresseurNoPokemons = new DresseurEntity(1L, "Pierre", "Kanto", List.of());

        PokemonEntity pikachu = new PokemonEntity(1L, "Pikachu", "electric", 99);
        PokemonEntity akwakwak = new PokemonEntity(1L, "Akwakwak", "eau", 10);

        dresseurPokemons = new DresseurEntity(1L, "Sacha", "Kanto", List.of(pikachu, akwakwak));
    }

    @Test
    void should_calculer_niveau_dresseur_equals_1_when_has_no_pokemon(){
        // Arrange
        when(dresseurRepository.findById(1L)).thenReturn(Optional.of(dresseurNoPokemons));

        // Act
        int result = dresseurService.calculerNiveauDresseur(1L);

        // Assert
        assertEquals(1,  result);
    }

    @Test
    void should_calculer_niveau_dresseur_equals_119_when_pokemons(){
        // Arrange
        when(dresseurRepository.findById(1L)).thenReturn(Optional.of(dresseurPokemons));

        //Act
        int result = dresseurService.calculerNiveauDresseur(1L);

        //ASert
        assertEquals(119,  result);
    }
}
