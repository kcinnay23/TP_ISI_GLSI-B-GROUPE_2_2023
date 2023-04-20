package com.IAI_GLSI.API_EGA.controller;

import com.IAI_GLSI.API_EGA.models.Client;
import com.IAI_GLSI.API_EGA.models.Compte;
import com.IAI_GLSI.API_EGA.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compte")
@AllArgsConstructor
public class CompteController {

    private final CompteService compteService;
    @PostMapping("/add")
    public Compte create(@RequestBody Compte compte) {
        return compteService.creer(compte);
    }
    @GetMapping("/")
    public List<Compte> read() {
        return compteService.lire();
    }
    @PutMapping("/update/{id}")
    public Compte update(@PathVariable Long id, @RequestBody Compte compte) {
        return compteService.modifier(id, compte);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return compteService.supprimer(id);
    }

    // depositAmount
    @PutMapping("/{numCompte}/deposit/{amount}")
    public String depositAmount(@PathVariable String numCompte, @PathVariable double amount) {
        //int initBal = getBalance(acctID);
        return compteService.depositAmount(numCompte, amount);
        //Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
        //loggerController.addLog(logger);
    }

    // withdrawAmount
    @PutMapping("/{numCompte}/withdraw/{amount}")
    public String withdrawAmount(@PathVariable String numCompte, @PathVariable double amount) {
        //int initBal = getSolde(acctID);
        return compteService.withdrawAmount(numCompte, amount);
        //Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
        //loggerController.addLog(logger);
    }

    // transferAmount
    @PutMapping("/{numCompte}/transfer/{destAcctID}/{amount}")
    public String transferAmount(@PathVariable String numCompte, @PathVariable String destAcctID, @PathVariable double amount) {
        //int initBalSender = getSolde(acctID);
        //int initBalReceiver = getSolde(destAcctID);
        return compteService.transferAmount(numCompte, destAcctID, amount);
        //Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
        //loggerController.addLog(loggerSender);
        //Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
        //        initBalReceiver + amount);
        //loggerController.addLog(loggerReceiver);
    }
}
