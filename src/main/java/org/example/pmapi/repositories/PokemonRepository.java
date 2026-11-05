package org.example.pmapi.repositories;

import org.example.pmapi.entities.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity,Long> {
}
