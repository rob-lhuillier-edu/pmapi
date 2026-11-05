package org.example.pmapi.repositories;

import org.example.pmapi.entities.DresseurEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class DresseurRepositoryTest {

    @Autowired
    private DresseurRepository dresseurRepository;

    @Test
    public void should_be_2_dresseurs_persisted() {
        //Arrange -> data.sql

        //act
        List<DresseurEntity> dresseurs = dresseurRepository.findAll();

        //assert
        assertEquals(2,  dresseurs.size());
    }

    @Test
    public void first_dresseur_should_be_sasha() {
        //Arrange -> data.sql

        //access
        Optional<DresseurEntity> dresseur = dresseurRepository.findById(1L);

        // Assert
        assertTrue(dresseur.isPresent());
        assertEquals("Sacha",dresseur.get().getNom());
    }
}
