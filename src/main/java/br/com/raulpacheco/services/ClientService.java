package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ClientDAO;
import br.com.raulpacheco.models.bo.Client;

public class ClientService extends GenericService<Client, ClientDAO> {
    public ClientService() {
        super(new ClientDAO());
    }
}
