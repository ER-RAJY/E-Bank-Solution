package com.example.E_Bank.Solution.service.impl;


import com.example.E_Bank.Solution.model.CarteBancaire;
import com.example.E_Bank.Solution.model.Compte;
import com.example.E_Bank.Solution.model.Utilisateur;
import com.example.E_Bank.Solution.model.enums.TypeCarte;
import com.example.E_Bank.Solution.model.enums.TypeCompte;
import com.example.E_Bank.Solution.repository.CarteBancaireRepository;
import com.example.E_Bank.Solution.repository.CompteRepository;
import com.example.E_Bank.Solution.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CompteServiceImpl {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CarteBancaireRepository carteBancaireRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Compte creerCompteEtCarte(Long utilisateurId, TypeCompte typeCompte, double soldeInitial) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        boolean compteExiste = utilisateur.getComptes().stream()
                .anyMatch(compte -> compte.getType().equals(typeCompte));
        if (compteExiste) {
            throw new IllegalArgumentException("Un compte de ce type existe déjà pour cet utilisateur.");
        }

        Compte compte = new Compte();
        compte.setType(typeCompte);
        compte.setSolde(soldeInitial);
        compte.setDateCreation(LocalDate.now());
        compte.setActif(true);
        compte.setUtilisateur(utilisateur);
        compteRepository.save(compte);


        CarteBancaire carteBancaire = new CarteBancaire();
        carteBancaire.setNumero(UUID.randomUUID().toString());
        carteBancaire.setDateExpiration(LocalDate.now().plusYears(4));
        carteBancaire.setType(TypeCarte.DEBIT);
        carteBancaire.setActive(true);
        carteBancaire.setBloquee(false);
        carteBancaire.setCompte(compte);
        carteBancaireRepository.save(carteBancaire);

        return compte;
    }

    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }


    public List<Compte> getComptesByUser(Utilisateur utilisateur){
        return compteRepository.findAllByUtilisateurIs(utilisateur);
    }

    public Compte getCompteById(Long id) {
        return compteRepository.findById(id).get();
    }

    public void deleteAccount(Compte compte) throws Exception {
        Compte compteClosed = compteRepository.findById(compte.getId()).orElseThrow(()-> new Exception("Not found!!"));
        if (compteClosed.getSolde()!=0){
            throw new Exception("Account be zero to close!!");
        }
        compteRepository.delete(compte);
    }
}
