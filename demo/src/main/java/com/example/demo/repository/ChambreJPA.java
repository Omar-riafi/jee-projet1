package com.example.demo.repository;

import com.example.demo.model.Chambre;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreJPA extends JpaRepository<Chambre, Long> {
    @Query("SELECT c FROM Chambre c WHERE c.surface = :surface")
    List<Chambre> findBySurface(Float surface);

    @Modifying
    @Query("DELETE FROM Chambre c WHERE c.surface = :surface")
    List<Chambre> deleteChambreBySurface(Float surface);

    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.statut = :statut")
    long countByStatut(String statut);


}
