package com.example.demo.controller;

import com.example.demo.model.Resident;
import com.example.demo.repository.ResidentJPA;
import com.example.demo.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/resident")
public class ResidentController {
    @Autowired
    private ResidentService residentService;
    public ResidentController(ResidentJPA residentJPA) {
        this.residentService = residentService;
    }
    @GetMapping("/getAllResidents")
    public List<Resident> getAllResidents() {
        return residentService.getAllResidents();
    }

    @GetMapping("/getResidentById/{id}")
    public Resident getResidentById(@PathVariable Long id) {
        return residentService.getResidentById(id);
    }

    @PostMapping("/addResident")
    public Resident addResident(@RequestBody Resident resident) {
        return residentService.addResident(resident);
    }

    @PutMapping("/updateResident/{id}")
    public Resident updateResident(@PathVariable Long id, @RequestBody Resident residentDetails) {
        residentDetails.setId(id); // S'assurer que l'ID est défini
        return residentService.updateResident(residentDetails);
    }

    @DeleteMapping("/deleteResident/{id}")
    public void deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
    }

    @PutMapping("/mettreAJourContact/{id}")
    public void mettreAJourContact(@PathVariable Long id, @RequestParam String nouveauContact) {
        residentService.mettreAJourContact(id, nouveauContact);
    }

    @GetMapping("/consulterProfil/{id}")
    public String consulterProfil(@PathVariable Long id) {
        return residentService.consulterProfil(id);
    }

    @PostMapping("/declarerIncident/{id}")
    public void declarerIncident(@PathVariable Long id, @RequestParam String descriptionIncident) {
        residentService.declarerIncident(id, descriptionIncident);
    }
}
