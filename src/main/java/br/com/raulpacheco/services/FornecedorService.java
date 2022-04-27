package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.FornecedorDAO;
import br.com.raulpacheco.models.bo.Fornecedor;

public class FornecedorService extends GenericService<Fornecedor, FornecedorDAO> {
    public FornecedorService() {
        super(new FornecedorDAO());
    }
}
