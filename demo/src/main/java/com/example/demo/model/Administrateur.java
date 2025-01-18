package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy = "administrateur")
    private Set<DemandeMaintenances> demandeMaintenances;
    @OneToMany(mappedBy = "administrateur")
    private Set<Resident> residents;
    @OneToMany(mappedBy = "administrateur")
    private Set<Chambre> chambre;
    @OneToMany(mappedBy = "administrateur")
    private Set<Statistiques> statistiques;

    public Administrateur() {
    }

    public Administrateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Administrateur(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<DemandeMaintenances> getDemandeMaintenances() {
        return demandeMaintenances;
    }

    public void setDemandeMaintenances(Set<DemandeMaintenances> demandeMaintenances) {
        this.demandeMaintenances = demandeMaintenances;
    }

    public Set<Resident> getResidents() {
        return residents;
    }

    public void setResidents(Set<Resident> residents) {
        this.residents = residents;
    }

    public Set<Chambre> getChambre() {
        return chambre;
    }

    public void setChambre(Set<Chambre> chambre) {
        this.chambre = chambre;
    }

    public Set<Statistiques> getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(Set<Statistiques> statistiques) {
        this.statistiques = statistiques;
    }
}
