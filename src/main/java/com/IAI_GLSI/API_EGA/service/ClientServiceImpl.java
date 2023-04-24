package com.IAI_GLSI.API_EGA.service;

import com.IAI_GLSI.API_EGA.models.Client;
import com.IAI_GLSI.API_EGA.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService  {

    private final ClientRepository clientRepository;
    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> lire() {
        return clientRepository.findAll();
    }

    @Override
    public Client modifier(Long numClient, Client client) {
        return clientRepository.findById(numClient)
                .map(c -> {
                    c.setNom(client.getNom());
                    c.setPrenom(client.getPrenom());
                    c.setDateNaiss(client.getDateNaiss());
                    c.setSexe(client.getSexe());
                    c.setAdresse(client.getAdresse());
                    c.setNumTel(client.getNumTel());
                    c.setCourriel(client.getCourriel());
                    c.setNationalite(client.getNationalite());
                    return clientRepository.save(c);
                }).orElseThrow(()-> new RuntimeException("Client non trouvé !"));
    }
    @Override
    public String supprimer(Long numClient) {
        clientRepository.deleteById(numClient);
        return "client Supprimé!";
    }
}
