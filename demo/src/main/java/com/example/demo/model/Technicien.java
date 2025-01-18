package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String specialite;
    @ManyToMany(mappedBy = "techniciens") // Reference to the mapped field in DemandeMaintenances
    private Set<DemandeMaintenances> demandes;

    public Technicien() {

    }
    public Technicien(Long id,
                      String name,
                      String specialite) {
        this.id = id;
        this.name = name;
        this.specialite = specialite;
    }

    public Technicien(String name,
                      String specialite) {
        this.name = name;
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Set<DemandeMaintenances> getDemandes() {
        return demandes;
    }

    public void setDemandes(Set<DemandeMaintenances> demandes) {
        this.demandes = demandes;
    }
}
