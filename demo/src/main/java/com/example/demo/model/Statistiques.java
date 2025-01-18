package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Statistiques {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double tauxOccupation;
    private int incidentsEnCours;
    private int paiementsEnRetard;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateur administrateur;

    public Statistiques() {
    }

    public Statistiques(Double tauxOccupation, int incidentsEnCours, int paiementsEnRetard) {
        this.tauxOccupation = tauxOccupation;
        this.incidentsEnCours = incidentsEnCours;
        this.paiementsEnRetard = paiementsEnRetard;
    }

    public Statistiques(int incidentsEnCours, int paiementsEnRetard) {
        this.incidentsEnCours = incidentsEnCours;
        this.paiementsEnRetard = paiementsEnRetard;
    }

    @Override
    public String toString() {
        return "Statistiques{" +
                "tauxOccupation=" + tauxOccupation +
                ", incidentsEnCours=" + incidentsEnCours +
                ", paiementsEnRetard=" + paiementsEnRetard +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getTauxOccupation() {
        return tauxOccupation;
    }

    public void setTauxOccupation(Double tauxOccupation) {
        this.tauxOccupation = tauxOccupation;
    }

    public int getIncidentsEnCours() {
        return incidentsEnCours;
    }

    public void setIncidentsEnCours(int incidentsEnCours) {
        this.incidentsEnCours = incidentsEnCours;
    }

    public int getPaiementsEnRetard() {
        return paiementsEnRetard;
    }

    public void setPaiementsEnRetard(int paiementsEnRetard) {
        this.paiementsEnRetard = paiementsEnRetard;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}
