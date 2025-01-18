package com.example.demo.controller;

import com.example.demo.model.Chambre;
import com.example.demo.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreController {
    @Autowired
    private ChambreService chambreService;
    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre upChambre) {
           return chambreService.updateChambre(upChambre);
    }

    @GetMapping("/getAllChambres")
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }

    @DeleteMapping("/deleteBySurface/{surface}")
    public void deleteBySurface(@PathVariable Float surface) {
        chambreService.deleteChambreBySurface(surface);
    }

    @PutMapping("/addChambre/{id}")
    public Chambre addChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @GetMapping("/getChambreBySurface/{surface}")
    public List<Chambre> getChambreBySurface(@PathVariable Float surface) {
        return chambreService.getChambreBySurface(surface);
    }

    @GetMapping("/GetById/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }

}
