package com.example.demo.model;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Set;

//@Setter
//@Getter
@Entity
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String adresse;
    private int nombreEtages;
    private int capaciteTotal;
    @OneToMany(mappedBy = "batiment")
    private Set<Chambre> chambres;
    public Batiment() {
    }

    public Batiment(Long id, String nom, String adresse, int nombreEtages, int capaciteTotal) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nombreEtages = nombreEtages;
        this.capaciteTotal = capaciteTotal;
    }

    public Batiment(String nom, String adresse, int nombreEtages, int capaciteTotal) {
        this.nom = nom;
        this.adresse = adresse;
        this.nombreEtages = nombreEtages;
        this.capaciteTotal = capaciteTotal;
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nombreEtages=" + nombreEtages +
                ", capaciteTotal=" + capaciteTotal +
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNombreEtages() {
        return nombreEtages;
    }

    public void setNombreEtages(int nombreEtages) {
        this.nombreEtages = nombreEtages;
    }

    public int getCapaciteTotal() {
        return capaciteTotal;
    }

    public void setCapaciteTotal(int capaciteTotal) {
        this.capaciteTotal = capaciteTotal;
    }

    public Set<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(Set<Chambre> chambres) {
        this.chambres = chambres;
    }
}
