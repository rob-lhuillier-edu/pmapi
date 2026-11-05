package org.example.pmapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemons")
public class PokemonEntity {

    public PokemonEntity() {
    }

    public PokemonEntity(Long id, String nom, String type, int niveau) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

    @Column(name = "niveau")
    private int niveau;

    @ManyToOne
    @JoinColumn(name = "dresseur_id")
    private DresseurEntity dresseur;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public DresseurEntity getDresseur() {
        return dresseur;
    }

    public void setDresseur(DresseurEntity dresseur) {
        this.dresseur = dresseur;
    }
}
