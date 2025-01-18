package com.example.demo.repository;

import com.example.demo.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicienJPA extends JpaRepository<Technicien, Long> {
}
