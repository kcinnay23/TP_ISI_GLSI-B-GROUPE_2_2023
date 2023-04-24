package com.IAI_GLSI.API_EGA.service;

import com.IAI_GLSI.API_EGA.models.Compte;
import com.IAI_GLSI.API_EGA.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CompteService {
    Compte creer(Compte compte);
    List<Compte> lire();
    Compte modifier(Long id, Compte compte);
    String supprimer(Long id);
    String depositAmount(String numCompte, double amount);
    String withdrawAmount(String numCompte, double amount);
    String transferAmount(String numCompte, String destAcctID, double amount);
}
