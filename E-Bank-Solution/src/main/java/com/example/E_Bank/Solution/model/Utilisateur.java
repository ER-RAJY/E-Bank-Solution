package com.example.E_Bank.Solution.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long utilisateur_id;
    private  String user_name ;
    private String email ;
    private String phone ;
    private String adresse ;
    private String password;
    @OneToMany(mappedBy = "utilisateur")
    private List<Compte> comptes ;
}

//   @JsonIgnore //eviter boucle qui get all users