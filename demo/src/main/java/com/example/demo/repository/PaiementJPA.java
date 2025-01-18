package com.example.demo.repository;

import com.example.demo.model.Paiement;
import com.example.demo.model.StatusPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaiementJPA extends JpaRepository<Paiement, Long> {
    @Query("SELECT p FROM Paiement p WHERE p.status = :status")
    List<Paiement> findByStatus(StatusPaiement status);

    @Query("SELECT COUNT(p) FROM Paiement p WHERE p.status = :status")
    long countByStatus(StatusPaiement status);

}
