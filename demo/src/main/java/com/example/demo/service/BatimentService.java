package com.example.demo.service;

import com.example.demo.model.Batiment;
import com.example.demo.repository.BatimentJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatimentService {
    @Autowired
    private BatimentJPA batimentJPA;

    public Batiment updateBatiment(Long id, Batiment x) {
        Optional<Batiment> existingBatiment = batimentJPA.findById(id);
        if (existingBatiment.isPresent()) {
            Batiment batiment = existingBatiment.get();
            batiment.setNom(x.getNom());
            batiment.setAdresse(x.getAdresse());
            batiment.setNombreEtages(x.getNombreEtages());
            batiment.setCapaciteTotal(x.getCapaciteTotal());
            if (x.getChambres() != null) {
                batiment.setChambres(x.getChambres());
            }
            return batimentJPA.save(batiment);
        }
        return null;
    }
    public Batiment addBatiment(Batiment batiment) {
        return batimentJPA.save(batiment);
    }
    public void removeBatiment(Long id) {
        batimentJPA.deleteById(id);
    }
    public Batiment getBatimentById(Long id) {
        Optional<Batiment> batiment = batimentJPA.findById(id);
        if (batiment.isPresent()) {
            return batiment.get();
        }
        return null;
    }

    public List<Batiment> getAllBatiments() {
        return batimentJPA.findAll();
    }
}
