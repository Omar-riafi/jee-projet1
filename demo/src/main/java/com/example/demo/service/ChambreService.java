package com.example.demo.service;

import com.example.demo.model.Chambre;
import com.example.demo.repository.ChambreJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {
    @Autowired
    private ChambreJPA chambreJPA;

    public List<Chambre> getAllChambres() {
        return chambreJPA.findAll();
    };

    public Chambre getChambreById(Long id) {
        Optional<Chambre> o1 = chambreJPA.findById(id);
        if (o1.isPresent()) {
            return o1.get();        // return test.orElse(null);
        }
        return null;
    }

    public List<Chambre> getChambreBySurface(Float surface) {
        return chambreJPA.findBySurface(surface);
    }

    public Chambre addChambre(Chambre chambre) {
        return chambreJPA.save(chambre);
    }

    public void deleteChambre(Long id) {
        chambreJPA.deleteById(id);
    }

    public Chambre updateChambre(Chambre chambre) {
        Optional<Chambre> o2 = chambreJPA.findById(chambre.getId());
        if (o2.isPresent()) {
            Chambre chambre1 = o2.get();
            chambre1.setSurface(chambre.getSurface());
            chambre1.setCapacite(chambre.getCapacite());
            return chambreJPA.save(chambre1);
        }
        return null;
    }

    public void deleteChambreBySurface(Float surface) {
        chambreJPA.deleteChambreBySurface(surface);
    }
}
