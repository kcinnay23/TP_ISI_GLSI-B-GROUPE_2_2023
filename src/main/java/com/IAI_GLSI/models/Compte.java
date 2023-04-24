package com.IAI_GLSI.API_EGA.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "Compte")
@Getter
@Setter
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String numCompte ;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type typeCompte ;
    @Column(nullable = false)
    private Date dateCreation;
    @Column(nullable = false)
    private Double solde;
    @PrePersist
    private void initAttribut() {
        if (solde == null) {
            solde = 0.0;
        }
        if (numCompte == null) {
            numCompte = generateAccountNumber();
        }
        if (dateCreation == null) {
            dateCreation = new Date();
        }
    }
    

    @ManyToOne()
    @JsonIgnoreProperties(value = {"nom", "prenom", "dateNaiss", "adresse", "numTel", "courriel", "nationalite", "comptes", "sexe"})
    @JoinColumn(name="numClient")
    private Client proprietaire;
}
