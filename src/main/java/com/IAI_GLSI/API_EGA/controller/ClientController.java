package com.IAI_GLSI.API_EGA.controller;

import com.IAI_GLSI.API_EGA.models.Client;
import com.IAI_GLSI.API_EGA.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/add")
    public Client create(@RequestBody Client client) {
        return clientService.creer(client);
    }

    @GetMapping("/")
    public List<Client> read() {
        return clientService.lire();
    }

    @PutMapping("/update/{numClient}")
    public Client update(@PathVariable Long numClient, @RequestBody Client client) {
        return clientService.modifier(numClient, client);
    }

    @DeleteMapping("/delete/{numClient}")
    public String delete(@PathVariable Long numClient) {
        return clientService.supprimer(numClient);
    }
}
