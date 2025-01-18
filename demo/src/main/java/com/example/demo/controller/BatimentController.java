package com.example.demo.controller;

import com.example.demo.model.Batiment;
import com.example.demo.service.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batiment")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;
    public BatimentController() {
        this.batimentService = new BatimentService();
    }

    @PutMapping("/updateBatiment/{id}")
    public Batiment updateBatiment(@PathVariable Long id, @RequestBody Batiment updatedBatiment) {
        return batimentService.updateBatiment(id, updatedBatiment);
    }

    @PostMapping("/addBatiment")
    public Batiment addBatiment(@RequestBody Batiment batiment) {
        return batimentService.addBatiment(batiment);
    }

    @DeleteMapping("/deleteBatiment/{id}")
    public void deleteBatiment(@PathVariable Long id) {
        batimentService.removeBatiment(id);
    }

    @GetMapping("/getBatimentById/{id}")
    public Batiment getBatimentById(@RequestParam Long id) {
        return batimentService.getBatimentById(id);
    }

    @GetMapping("/getAllBatiments")
    public List<Batiment> getAllBatiments() {
        return batimentService.getAllBatiments();
    }
}
