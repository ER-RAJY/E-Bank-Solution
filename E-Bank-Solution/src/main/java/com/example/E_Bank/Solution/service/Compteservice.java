package com.example.E_Bank.Solution.service;

import com.example.E_Bank.Solution.model.Compte;

import java.util.List;

public interface Compteservice {
    public Compte creerCompteEtCarte();
    public List<Compte> getComptes();
}
