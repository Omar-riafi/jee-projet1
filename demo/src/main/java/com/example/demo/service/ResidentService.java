package com.example.demo.service;

import com.example.demo.model.Resident;
import com.example.demo.repository.ResidentJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentService {

    @Autowired
    private ResidentJPA residentJPA;
    public ResidentService(){
        this.residentJPA = residentJPA;
    }

    public List<Resident> getAllResidents() {
        return residentJPA.findAll();
    }

    public Resident getResidentById(Long id) {
        Optional<Resident> resident = residentJPA.findById(id);
        if(resident.isPresent()) {
            return resident.get();
        }
        return null;
    }

    public Resident addResident(Resident resident) {
        return residentJPA.save(resident);
    }

    public Resident updateResident(Resident residentDetails) {
        Optional<Resident> o3 = residentJPA.findById(residentDetails.getId());
        if (o3.isPresent()) {
            Resident resident = o3.get();
            resident.setNom(residentDetails.getNom());
            resident.setPrenom(residentDetails.getPrenom());
            resident.setContact(residentDetails.getContact());
            resident.setNumeroChambre(residentDetails.getNumeroChambre());
            resident.setDateArrivee(residentDetails.getDateArrivee());
            resident.setStatutPaiement(residentDetails.getStatutPaiement());
            return residentJPA.save(resident);
        }
        return null;
    }

    public void deleteResident(Long id) {
        residentJPA.deleteById(id);
    }

    public void mettreAJourContact(Long residentId, String nouveauContact) {
        Optional<Resident> o4 = residentJPA.findById(residentId);
        if (o4.isPresent()) {
            Resident resident = o4.get();
            resident.setContact(nouveauContact);
            residentJPA.save(resident); // Sauvegarder les modifications dans la base
        }
    }

    public String consulterProfil(Long residentId) {
        Optional<Resident> optionalResident = residentJPA.findById(residentId);
        return optionalResident.map(Resident::consulterProfil).orElse("Profil non trouvé.");
    }

    public void declarerIncident(Long residentId, String descriptionIncident) {
        Optional<Resident> optionalResident = residentJPA.findById(residentId);
        if (optionalResident.isPresent()) {
            Resident resident = optionalResident.get();
            resident.declarerIncident(descriptionIncident);
        }
    }

}