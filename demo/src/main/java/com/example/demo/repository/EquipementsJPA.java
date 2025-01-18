package com.example.demo.repository;

import com.example.demo.model.Administrateur;
import com.example.demo.model.Equipements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementsJPA extends JpaRepository<Equipements, Long> {
}
