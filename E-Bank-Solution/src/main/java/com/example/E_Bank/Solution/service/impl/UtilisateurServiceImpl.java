package com.example.E_Bank.Solution.service.impl;


import com.example.E_Bank.Solution.model.Utilisateur;
import com.example.E_Bank.Solution.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).get();
    }
}
