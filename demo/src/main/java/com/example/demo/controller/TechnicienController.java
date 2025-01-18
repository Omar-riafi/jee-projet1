package com.example.demo.controller;

import com.example.demo.model.Technicien;
import com.example.demo.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("technecien")
public class TechnicienController {
    @Autowired
    private TechnicienService technicienService;

    @GetMapping("/getAllTechnicien")
    public List<Technicien> getAllTechniciens() {
        return technicienService.getAllTechniciens();
    }

    @GetMapping("/getTechnicienById/{id}")
    public Technicien getTechnicienById(@PathVariable Long id) {
        return technicienService.getTechnicienById(id);
    }

    @PostMapping("/createTechnicien")
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        return technicienService.createTechnicien(technicien);
    }

    @PutMapping("/updateTechnecien/{id}")
    public Technicien updateTechnicien(@PathVariable Long id, @RequestBody Technicien updatedTechnicien) {
        return technicienService.updateTechnicien(id, updatedTechnicien);
    }

    @DeleteMapping("/deleteTechnecien/{id}")
    public void deleteTechnicien(@PathVariable Long id) {
        technicienService.deleteTechnicien(id);
    }

    @PostMapping("/traiterDemande{demandeId}")
    public void traiterDemande(@PathVariable Long demandeId) {
        technicienService.traiterDemande(demandeId);
    }
}
