package com.example.demo.controller;

import com.example.demo.service.StatistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("statistiques")
public class StatistiquesController {
    @Autowired
    private StatistiquesService statistiquesService;
    public StatistiquesController(){
        this.statistiquesService = new StatistiquesService();
    }

    @GetMapping("/getTauxOccupation")
    public double getTauxOccupation() {
        return statistiquesService.calculerTauxOccupation();
    }

    @GetMapping("/getPaiementsEnRetard")
    public long getPaiementsEnRetard() {
        return statistiquesService.paiementsEnRetard();
    }

    @GetMapping("/getIncidentsEnCours")
    public long getIncidentsEnCours() {
        return statistiquesService.incidentsEnCours();
    }

    @GetMapping("/getRapportGeneral")
    public Map<String, Object> getRapportGeneral() {
        return statistiquesService.genererRapport();
    }
}
