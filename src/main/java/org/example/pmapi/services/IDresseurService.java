package org.example.pmapi.services;

import org.example.pmapi.dto.DresseurDTO;
import org.example.pmapi.entities.DresseurEntity;

public interface IDresseurService {

    public int calculerNiveauDresseur(Long dresseurId);

    public DresseurDTO toDTO(DresseurEntity dresseurEntity);

    public DresseurDTO get(Long dresseurId);
}
