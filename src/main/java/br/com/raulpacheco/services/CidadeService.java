package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.CidadeDAO;
import br.com.raulpacheco.models.bo.Cidade;

public class CidadeService extends GenericService<Cidade, CidadeDAO> {

    public CidadeService() {
        super(new CidadeDAO());
    }
}
