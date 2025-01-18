package com.example.demo.controller;

import com.example.demo.model.DemandeMaintenances;
import com.example.demo.model.StatusMaintenance;
import com.example.demo.model.Technicien;
import com.example.demo.service.DemandeMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demandeMaintenance")
public class DemandeMaintenanceController {

    @Autowired
    private DemandeMaintenanceService demandeMaintenancesService;
    public DemandeMaintenanceController(){
        this.demandeMaintenancesService = new DemandeMaintenanceService();
    }

    @GetMapping("/getDemandeById/{id}")
    public DemandeMaintenances getDemandeById(@PathVariable Long id) {
        return demandeMaintenancesService.getDemandeById(id);
    }

    @PostMapping("/createDemande")
    public DemandeMaintenances createDemande(@RequestBody DemandeMaintenances demande) {
        return demandeMaintenancesService.createDemande(demande);
    }

    @PutMapping("/updateDemande/{id}")
    public DemandeMaintenances updateDemande(@PathVariable Long id, @RequestBody DemandeMaintenances updatedDemande) {
        return demandeMaintenancesService.updateDemande(id, updatedDemande);
    }

    @DeleteMapping("/deleteDemande/{id}")
    public void deleteDemande(@PathVariable Long id) {
        demandeMaintenancesService.deleteDemande(id);
    }

    @PostMapping("/assignerTechnicien/{id}")
    public void assignerTechnicien(@PathVariable Long id, @RequestBody Technicien technicien) {
        demandeMaintenancesService.assignerTechnicien(id, technicien);
    }

    @PostMapping("/mettreAJourStatut/{id}")
    public void mettreAJourStatut(@PathVariable Long id, @RequestParam StatusMaintenance nouveauStatut) {
        demandeMaintenancesService.mettreAJourStatut(id, nouveauStatut);
    }
}
