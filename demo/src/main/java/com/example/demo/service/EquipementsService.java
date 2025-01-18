package com.example.demo.service;

import com.example.demo.model.Equipements;
import com.example.demo.repository.EquipementsJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementsService {

    @Autowired
    private EquipementsJPA equipementJPA;

    public List<Equipements> getAllEquipements() {
        return equipementJPA.findAll();
    }

    public Equipements getEquipementById(Long id) {
        Optional<Equipements> equipements = equipementJPA.findById(id);
        if (equipements.isPresent()) {
            return equipements.get();
        }
        return null;
    }

    public Equipements addEquipement(Equipements equipement) {
        return equipementJPA.save(equipement);
    }

    public Equipements updateEquipement(Long id, Equipements updatedEquipement) {
        Optional<Equipements> existingEquipement = equipementJPA.findById(id);
        if (existingEquipement.isPresent()) {
            Equipements equipement = existingEquipement.get();
            equipement.setNom(updatedEquipement.getNom());
            equipement.setDescription(updatedEquipement.getDescription());
            if (updatedEquipement.getChambres() != null) {
                equipement.setChambres(updatedEquipement.getChambres());
            }
            return equipementJPA.save(equipement);
        }
        return null;
    }

    public void deleteEquipement(Long id) {
        equipementJPA.deleteById(id);
    }
}
