package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.AddressDAO;
import br.com.raulpacheco.models.bo.Endereco;

public class AddressService extends GenericService<Endereco, AddressDAO> {
    public AddressService() {
        super(new AddressDAO());
    }
}
