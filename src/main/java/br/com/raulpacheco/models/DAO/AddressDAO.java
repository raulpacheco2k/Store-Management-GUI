package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.Endereco;

public class AddressDAO extends GenericDAO<Endereco> {

    BairroDAO BairroDAO;
    CidadeDAO CidadeDAO;

    public AddressDAO() {
        this.BairroDAO = new BairroDAO();
        this.CidadeDAO = new CidadeDAO();
    }
}
