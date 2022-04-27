package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.BairroDAO;
import br.com.raulpacheco.models.bo.Bairro;

public class BairroService extends GenericService<Bairro, BairroDAO> {
    public BairroService() {
        super(new BairroDAO());
    }
}
