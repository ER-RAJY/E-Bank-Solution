package com.example.E_Bank.Solution.repo;

import com.example.E_Bank.Solution.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
