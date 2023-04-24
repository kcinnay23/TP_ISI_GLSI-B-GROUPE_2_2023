package com.IAI_GLSI.API_EGA.repository;

import com.IAI_GLSI.API_EGA.models.Client;
import com.IAI_GLSI.API_EGA.models.Compte;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Compte set solde = solde+?2 where numCompte=?1")
    public void saveBalanceByAcctID(String numCompte, double solde);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Compte set solde = solde-?2 where numCompte=?1")
    public void withdrawAmountByAcctID(String numCompte,double solde);

}
