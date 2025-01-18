package com.example.demo.service;

import com.example.demo.model.Paiement;
import com.example.demo.model.StatusPaiement;
import com.example.demo.repository.PaiementJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {
    @Autowired
    private PaiementJPA paiementJPA;

    public List<Paiement> getAllPaiements() {
        return paiementJPA.findAll();
    }

    public Paiement getPaiementById(Long id) {
        Optional<Paiement> o1 = paiementJPA.findById(id);
        if (o1.isPresent()) {
            return o1.get();        // return test.orElse(null);
        }
        return null;
    }

    public Paiement addPaiement(Paiement paiement) {
        return paiementJPA.save(paiement);
    }

    public Paiement updatePaiement(Paiement paiementDetails) {
        Optional<Paiement> o2 = paiementJPA.findById(paiementDetails.getId());
        if (o2.isPresent()) {
            Paiement paiement = o2.get();
            paiement.setId(paiementDetails.getId());
            paiement.setDatePaiement(paiementDetails.getDatePaiement());
            paiement.setStatus(paiementDetails.getStatus());
            paiement.setMontant(paiementDetails.getMontant());
            paiement.setResident(paiementDetails.getResident());
            return paiementJPA.save(paiement);
        }
        return null;
    }

    public void deletePaiement(Long id) {
        paiementJPA.deleteById(id);
    }

    public void genererRecu(Long paiementId) {
        System.out.println("Reçu généré pour le paiement ID : " + paiementId);
    }

    public void envoyerRappel(Long paiementId) {
        System.out.println("Rappel de paiement envoyé pour le paiement ID : " + paiementId);
    }

    public List<Paiement> getPaiementsByStatut(StatusPaiement statut) {
        return paiementJPA.findByStatus(statut);
    }
}

