package com.example.demo.controller;


import com.example.demo.model.Paiement;
import com.example.demo.model.StatusPaiement;
import com.example.demo.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;
    public  PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }

    @PostMapping
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Long id, @RequestBody Paiement paiementDetails) {
        paiementDetails.setId(id); // S'assurer que l'ID est correctement défini
        return paiementService.updatePaiement(paiementDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
    }

    @PostMapping("/genererRecu/{id}")
    public void genererRecu(@PathVariable Long id) {
        paiementService.genererRecu(id);
    }

    @PostMapping("/envoyerRappel/{id}")
    public void envoyerRappel(@PathVariable Long id) {
        paiementService.envoyerRappel(id);
    }

    @GetMapping("/getPaiementsByStatut/{statut}")
    public List<Paiement> getPaiementsByStatut(@PathVariable StatusPaiement statut) {
        return paiementService.getPaiementsByStatut(statut);
    }
}
