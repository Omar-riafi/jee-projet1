package com.example.demo.repository;

import com.example.demo.model.Statistiques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StatistiquesJPA extends JpaRepository<Statistiques, Long> {


}
