package com.IAI_GLSI.API_EGA.service;

import com.IAI_GLSI.API_EGA.models.Client;

import java.util.List;

public interface ClientService {
    Client creer(Client client);
    List<Client> lire();
    Client modifier(Long numClient, Client client);
    String supprimer(Long numClient);
}
