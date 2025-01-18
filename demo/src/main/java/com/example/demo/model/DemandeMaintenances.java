package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Entity
public class DemandeMaintenances {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Date date;
    private StatusMaintenance status;
    private String priorite;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateur administrateur;
    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToMany
    @JoinTable(
            name = "demande_technicien", // Join table name
            joinColumns = @JoinColumn(name = "demande_id"), // Foreign key to DemandeMaintenances
            inverseJoinColumns = @JoinColumn(name = "technicien_id") // Foreign key to Technicien
    )
    private Set<Technicien> techniciens;

    public DemandeMaintenances() {
    }
    public DemandeMaintenances(String description,
                               Date date,
                               StatusMaintenance statut,
                               String priorite) {
        this.description = description;
        this.date = date;
        this.status = statut;
        this.priorite = priorite;
    }

    public DemandeMaintenances(Date date, StatusMaintenance statut, String priorite) {
        this.date = date;
        this.status = statut;
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return "DemandeMaintenances{" +
                "description='" + description + '\'' +
                ", date=" + date +
                ", statut='" + status + '\'' +
                ", priorite='" + priorite + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusMaintenance getStatus() {
        return status;
    }

    public void setStatus(StatusMaintenance status) {
        this.status = status;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Set<Technicien> getTechniciens() {
        return techniciens;
    }

    public void setTechniciens(Set<Technicien> techniciens) {
        this.techniciens = techniciens;
    }
}
