package com.example.demo.repository;

import com.example.demo.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurJPA extends JpaRepository<Administrateur, Long> {
}
