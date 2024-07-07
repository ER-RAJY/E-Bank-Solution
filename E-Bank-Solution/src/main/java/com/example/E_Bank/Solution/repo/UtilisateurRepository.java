package com.example.E_Bank.Solution.repo;


import com.example.E_Bank.Solution.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
