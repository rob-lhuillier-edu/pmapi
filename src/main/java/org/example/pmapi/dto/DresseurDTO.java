package org.example.pmapi.dto;

public class DresseurDTO {

    private String nom;

    private int nombrePokemons;

    private int niveauDresseur;

    public DresseurDTO(String nom, int size, int niveauDresseur) {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombrePokemons() {
        return nombrePokemons;
    }

    public void setNombrePokemons(int nombrePokemons) {
        this.nombrePokemons = nombrePokemons;
    }

    public int getNiveauDresseur() {
        return niveauDresseur;
    }

    public void setNiveauDresseur(int niveauDresseur) {
        this.niveauDresseur = niveauDresseur;
    }

}
