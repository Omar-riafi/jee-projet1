package com.example.demo.service;

import com.example.demo.model.DemandeMaintenances;
import com.example.demo.model.StatusMaintenance;
import com.example.demo.model.Technicien;
import com.example.demo.repository.DemandeMaintenancesJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DemandeMaintenanceService {

    @Autowired
    private DemandeMaintenancesJPA demandeMaintenancesJPA;

    public List<DemandeMaintenances> getAllDemandes() {
        return demandeMaintenancesJPA.findAll();
    }

    public DemandeMaintenances getDemandeById(Long id) {
        Optional<DemandeMaintenances> o1 = demandeMaintenancesJPA.findById(id);
        if (o1.isPresent()){
            return o1.get();        // return test.orElse(null);
        }
        return null;
    }

    public DemandeMaintenances createDemande(DemandeMaintenances demande) {
        return demandeMaintenancesJPA.save(demande);
    }

    public DemandeMaintenances updateDemande(Long id, DemandeMaintenances updatedDemande) {
        Optional<DemandeMaintenances> o2 = demandeMaintenancesJPA.findById(updatedDemande.getId());
        if (o2.isPresent()) {
            DemandeMaintenances demandeMaintenances = o2.get();
            demandeMaintenances.setDescription(updatedDemande.getDescription());
            demandeMaintenances.setDate(updatedDemande.getDate());
            demandeMaintenances.setPriorite(updatedDemande.getPriorite());
            demandeMaintenances.setStatus(updatedDemande.getStatus());
            demandeMaintenances.setTechniciens(updatedDemande.getTechniciens());
            return demandeMaintenancesJPA.save(demandeMaintenances);
        }
        return null;
    }

    public void deleteDemande(Long id) {
        demandeMaintenancesJPA.deleteById(id);
    }

    public void assignerTechnicien(Long demandeId, Technicien technicien) {
        Optional<DemandeMaintenances> o2 = demandeMaintenancesJPA.findById(demandeId);
        if (o2.isPresent()) {
            DemandeMaintenances demandeMaintenances = o2.get();
            demandeMaintenances.getTechniciens().add(technicien);
            demandeMaintenancesJPA.save(demandeMaintenances);
        }
    }

    public void mettreAJourStatut(Long demandeId, StatusMaintenance nouveauStatut) {
        Optional<DemandeMaintenances> o2 = demandeMaintenancesJPA.findById(demandeId);
        if (o2.isPresent()) {
            DemandeMaintenances demandeMaintenances = o2.get();
            demandeMaintenances.setStatus(nouveauStatut);
            demandeMaintenancesJPA.save(demandeMaintenances);
        }
    }
}
