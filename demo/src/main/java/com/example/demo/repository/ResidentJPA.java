package com.example.demo.repository;

import com.example.demo.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentJPA extends JpaRepository<Resident,Long> {
}
