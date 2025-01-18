package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Float surface;
    private int capacite;
    @ManyToMany
    @JoinTable(
            name = "chambre_equipment", // Name of the join table
            joinColumns = @JoinColumn(name = "chambre_id"), // Foreign key for Classroom
            inverseJoinColumns = @JoinColumn(name = "equipment_id") // Foreign key for Equipment
    )
    private Set<Equipements> equipements;

    @ManyToOne
    @JoinColumn(name = "batiment_id")
    private Batiment batiment;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateur administrateur;

    @OneToMany(mappedBy = "chambre")
    private Set<DemandeMaintenances> demandeMaintenances;

    private StatusChambre statut;
    private Float prix;

    @OneToMany(mappedBy = "chambre")
    private Set<HistoriqueLogement> historiqueLogements;

    public Chambre() {
    }

    public Chambre(Long id, String nombre, Float surface, int capacite, Set<Equipements> equipements, StatusChambre statut, Float prix) {
        this.id = id;
        this.nombre = nombre;
        this.surface = surface;
        this.capacite = capacite;
        this.equipements = equipements;
        this.statut = statut;
        this.prix = prix;
    }

    public Chambre(String nombre, Float surface, int capacite, Set<Equipements> equipements, StatusChambre statut, Float prix) {
        this.nombre = nombre;
        this.surface = surface;
        this.capacite = capacite;
        this.equipements = equipements;
        this.statut = statut;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", surface=" + surface +
                ", capacite=" + capacite +
                ", equipements=" + equipements +
                ", statut='" + statut + '\'' +
                ", prix=" + prix +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getSurface() {
        return surface;
    }

    public void setSurface(Float surface) {
        this.surface = surface;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Set<Equipements> getEquipements() {
        return equipements;
    }

    public void setEquipements(Set<Equipements> equipements) {
        this.equipements = equipements;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Set<DemandeMaintenances> getDemandeMaintenances() {
        return demandeMaintenances;
    }

    public void setDemandeMaintenances(Set<DemandeMaintenances> demandeMaintenances) {
        this.demandeMaintenances = demandeMaintenances;
    }

    public StatusChambre getStatut() {
        return statut;
    }

    public void setStatut(StatusChambre statut) {
        this.statut = statut;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Set<HistoriqueLogement> getHistoriqueLogements() {
        return historiqueLogements;
    }

    public void setHistoriqueLogements(Set<HistoriqueLogement> historiqueLogements) {
        this.historiqueLogements = historiqueLogements;
    }
}
