package com.example.demo.service;

import com.example.demo.model.StatusMaintenance;
import com.example.demo.model.StatusPaiement;
import com.example.demo.repository.ChambreJPA;
import com.example.demo.repository.DemandeMaintenancesJPA;
import com.example.demo.repository.PaiementJPA;
import com.example.demo.repository.StatistiquesJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatistiquesService {
    @Autowired
    public StatistiquesJPA statistiquesJPA;

    @Autowired
    private ChambreJPA chambreJPA;

    @Autowired
    private PaiementJPA paiementJPA;

    @Autowired
    private DemandeMaintenancesJPA demandeMaintenancesJPA;

    public double calculerTauxOccupation() {
        long totalChambres = chambreJPA.count();
        long chambresOccupees = chambreJPA.countByStatut("occupée");
        return (totalChambres > 0) ? ((double) chambresOccupees / totalChambres) * 100 : 0.0;
    }

    public long paiementsEnRetard() {
        return paiementJPA.countByStatus(StatusPaiement.EN_RETARD);
    }

    public long incidentsEnCours() {
        return demandeMaintenancesJPA.countByStatus(StatusMaintenance.EN_COURS);
    }

    public Map<String, Object> genererRapport() {
        Map<String, Object> rapport = new HashMap<>();
        rapport.put("tauxOccupation", calculerTauxOccupation());
        rapport.put("paiementsEnRetard", paiementsEnRetard());
        rapport.put("incidentsEnCours", incidentsEnCours());
        return rapport;
    }
}
