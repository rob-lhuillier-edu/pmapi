package org.example.pmapi.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "dresseurs")
public class DresseurEntity {

    public DresseurEntity() {
    }

    public DresseurEntity(Long id, String nom, String region, List<PokemonEntity> pokemons) {
        this.id = id;
        this.nom = nom;
        this.region = region;
        this.pokemons = pokemons;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "region")
    private String region;

    @OneToMany(mappedBy = "dresseur")
    private List<PokemonEntity> pokemons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<PokemonEntity> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonEntity> pokemons) {
        this.pokemons = pokemons;
    }

    public int getNumberOfPokemonTypes() {
        HashSet<String> types = new HashSet<>();
        for (PokemonEntity pokemon : pokemons) {
            types.add(pokemon.getType());
        }
        return types.size();
    }
}
