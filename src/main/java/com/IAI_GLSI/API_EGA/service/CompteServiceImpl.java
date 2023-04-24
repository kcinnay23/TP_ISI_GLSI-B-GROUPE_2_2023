package com.IAI_GLSI.API_EGA.service;

import com.IAI_GLSI.API_EGA.models.Compte;
import com.IAI_GLSI.API_EGA.repository.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CompteServiceImpl implements CompteService{

    private final CompteRepository compteRepository;
    @Override
    public Compte creer(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> lire() {
        return compteRepository.findAll();
    }

    @Override
    public Compte modifier(Long id, Compte compte) {
        return compteRepository.findById(id)
                .map(compt -> {
                    compt.setNumCompte(compte.getNumCompte());
                    compt.setTypeCompte(compte.getTypeCompte());
                    compt.setDateCreation(compte.getDateCreation());
                    compt.setProprietaire(compte.getProprietaire());
                    return compteRepository.save(compte);
                }).orElseThrow(()-> new RuntimeException("Compte non trouvé !"));
    }
    @Override
    public String supprimer(Long id) {
        compteRepository.deleteById(id);
        return "Compte Supprimé!";
    }
    @Override
    public String depositAmount(String numCompte, double amount) {
        compteRepository.saveBalanceByAcctID(numCompte, amount);
        return "Dépôt d'une somme de "+ amount +" effectué avec succès sur le compte " + numCompte;
    }

    @Override
    public String withdrawAmount(String numCompte, double amount) {
        compteRepository.withdrawAmountByAcctID(numCompte, amount);
        return "Retrait d'une somme de "+ amount + " a été effectuer sur votre " + numCompte;
    }

    @Override
    public String transferAmount(String numCompte, String destAcctID, double amount) {
        compteRepository.withdrawAmountByAcctID(numCompte, amount);
        compteRepository.saveBalanceByAcctID(destAcctID, amount);
        return "Transfert éffectué avec succès" ;
    }
}
