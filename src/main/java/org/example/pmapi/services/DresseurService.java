package org.example.pmapi.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.pmapi.dto.DresseurDTO;
import org.example.pmapi.entities.DresseurEntity;
import org.example.pmapi.entities.PokemonEntity;
import org.example.pmapi.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DresseurService implements IDresseurService {

    @Autowired
    private DresseurRepository dresseurRepository;

    @Override
    public int calculerNiveauDresseur(Long dresseurId) {
        DresseurEntity dresseur =  dresseurRepository.findById(dresseurId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Dresseur introuvable avec l'id : " + dresseurId
                ));
        List<PokemonEntity> pokemons = dresseur.getPokemons();

        if (pokemons.isEmpty()) {
            return 1;
        }

        int dresseurLevel = dresseur.getPokemons().stream()
                .mapToInt(PokemonEntity::getNiveau)
                .sum();

        if (dresseur.getNumberOfPokemonTypes() >= 3) {
            dresseurLevel += 20;
        }

        dresseurLevel += (int) pokemons.stream()
                .filter(pokemon -> pokemon.getNiveau() >= 50)
                .count() * 10;

        return dresseurLevel;
    }

    @Override
    public DresseurDTO toDTO(DresseurEntity entity) {
        return new DresseurDTO(
                entity.getNom(),
                entity.getPokemons().size(),
                calculerNiveauDresseur(entity.getId())
        );
    }

    @Override
    public DresseurDTO get(Long dresseurId) {
        return toDTO(dresseurRepository.findById(dresseurId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Dresseur introuvable avec l'id : " + dresseurId
                ))
        );
    }
}
