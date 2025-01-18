package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity

public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String contact;
    private String numeroChambre;
    private Date dateArrivee;
    private String statutPaiement;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateur administrateur;

    @OneToMany(mappedBy = "resident")
    private Set<Paiement> paiements;

    @OneToMany(mappedBy = "resident")
    private Set<HistoriqueLogement> historiqueLogements;

    public Resident() {
    }

    public Resident(Long id,
                    String nom,
                    String prenom,
                    String contact,
                    String numeroChambre,
                    Date dateArrivee,
                    String statutPaiement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.numeroChambre = numeroChambre;
        this.dateArrivee = dateArrivee;
        this.statutPaiement = statutPaiement;
    }

    public Resident(String nom,
                    String prenom,
                    String contact,
                    String numeroChambre,
                    Date dateArrivee,
                    String statutPaiement) {
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.numeroChambre = numeroChambre;
        this.dateArrivee = dateArrivee;
        this.statutPaiement = statutPaiement;
    }

    @Override
    public String toString() {
        return "resident{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", contact='" + contact + '\'' +
                ", numeroChambre='" + numeroChambre + '\'' +
                ", dateArrivee=" + dateArrivee +
                ", statutPaiement='" + statutPaiement + '\'' +
                '}';
    }

    public String consulterProfil() {
        return "Profil Résident: [ID=" + id + ", Nom=" + nom + ", Prénom=" + prenom +
                ", Contact=" + contact + ", Numéro de Chambre=" + numeroChambre +
                ", Date d'Arrivée=" + dateArrivee + ", Statut Paiement=" + statutPaiement + "]";
    }

    // Méthode pour déclarer un incident
    public void declarerIncident(String descriptionIncident) {
        System.out.println("Incident déclaré : " + descriptionIncident);
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Set<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(Set<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Set<HistoriqueLogement> getHistoriqueLogements() {
        return historiqueLogements;
    }

    public void setHistoriqueLogements(Set<HistoriqueLogement> historiqueLogements) {
        this.historiqueLogements = historiqueLogements;
    }
}
