package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.DemandeMaintenancesJPA;
import com.example.demo.repository.TechnicienJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienService {

    @Autowired
    private TechnicienJPA technicienJPA;

    @Autowired
    private DemandeMaintenancesJPA demandeMaintenancesJPA;

    public List<Technicien> getAllTechniciens() {
        return technicienJPA.findAll();
    }

    public Technicien getTechnicienById(Long id) {
        Optional<Technicien> technicien = technicienJPA.findById(id);
        if(technicien.isPresent()) {
            return technicien.get();
        }
        return null;
    }

    public Technicien createTechnicien(Technicien technicien) {
        return technicienJPA.save(technicien);
    }

    public Technicien updateTechnicien(Long id, Technicien updatedTechnicien) {
        Optional<Technicien> technicien = technicienJPA.findById(id);
        if (technicien.isPresent()) {
            Technicien technicien1 = technicien.get();
            technicien1.setName(updatedTechnicien.getName());
            technicien1.setSpecialite(updatedTechnicien.getSpecialite());
            return technicienJPA.save(technicien1);
        }
        return null;
    }

    public void deleteTechnicien(Long id) {
        technicienJPA.deleteById(id);
    }

    public void traiterDemande(Long demandeId) {
        DemandeMaintenances demande = demandeMaintenancesJPA.findById(demandeId).orElse(null);
        if (demande != null) {
            demande.setStatus(StatusMaintenance.TERMINE);
            demandeMaintenancesJPA.save(demande);
            System.out.println("Demande ID " + demandeId );
        }
    }
}
