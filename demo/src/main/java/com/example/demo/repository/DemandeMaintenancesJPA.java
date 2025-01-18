package com.example.demo.repository;

import com.example.demo.model.DemandeMaintenances;
import com.example.demo.model.StatusMaintenance;
import com.example.demo.model.StatusPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DemandeMaintenancesJPA extends JpaRepository<DemandeMaintenances, Long> {
    @Query("SELECT COUNT(d) FROM DemandeMaintenances d WHERE d.status = :status")
    long countByStatus(StatusMaintenance status);
}
