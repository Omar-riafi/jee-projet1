package com.example.demo.controller;

import com.example.demo.model.Equipements;
import com.example.demo.service.EquipementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("equipements")
public class EquipementsController {
    @Autowired
    private EquipementsService equipementsService;
    public EquipementsController() {
        this.equipementsService = new EquipementsService();
    }

    @GetMapping("getAllEquipements")
    public List<Equipements> getAllEquipements() {
        return equipementsService.getAllEquipements();
    }

    @GetMapping("/getEquipementById/{id}")
    public Equipements getEquipementById(@PathVariable Long id) {
        return equipementsService.getEquipementById(id);
    }

    @PostMapping("/addEquipements")
    public Equipements addEquipement(@RequestBody Equipements equipement) {
        return equipementsService.addEquipement(equipement);
    }

    @PutMapping("/updateEquipements/{id}")
    public Equipements updateEquipement(@PathVariable Long id, @RequestBody Equipements updatedEquipement) {
        return equipementsService.updateEquipement(id, updatedEquipement);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable Long id) {
        equipementsService.deleteEquipement(id);
    }
}
