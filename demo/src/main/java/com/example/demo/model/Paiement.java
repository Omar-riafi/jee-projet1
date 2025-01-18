package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float montant;
    private Date datePaiement;
    private StatusPaiement status;
    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;


    public Paiement() {
    }

    public Paiement(Float montant, Date datePaiement, StatusPaiement status) {
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.status = status;
    }

    public Paiement(Long id, Float montant, Date datePaiement, StatusPaiement status) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", montant=" + montant +
                ", datePaiement=" + datePaiement +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public StatusPaiement getStatus() {
        return status;
    }

    public void setStatus(StatusPaiement status) {
        this.status = status;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
