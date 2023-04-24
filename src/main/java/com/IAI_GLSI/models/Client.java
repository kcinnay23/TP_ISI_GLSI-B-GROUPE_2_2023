package com.IAI_GLSI.API_EGA.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numClient ;
    @Column(length = 50, nullable = false)
    private String nom;
    @Column(length = 75, nullable = false)
    private String prenom;
    @Column(nullable = false)
    private Date dateNaiss;
    @Column(length = 10,nullable = false)
    private String Sexe;
    @Column(length = 150,nullable = false)
    private String adresse;
    @Column(length = 20,nullable = false)
    private String numTel;
    @Column(length = 25,nullable = false)
    private String courriel;
    @Column(length = 30,nullable = false)
    private String nationalite;
    @OneToMany(mappedBy = "proprietaire",targetEntity = Compte.class)
    private List<Compte> comptes ;


}
