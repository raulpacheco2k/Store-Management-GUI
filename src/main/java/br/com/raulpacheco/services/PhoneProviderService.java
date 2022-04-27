package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PhoneProviderDAO;
import br.com.raulpacheco.models.bo.PhoneProvider;

import java.util.List;

public class PhoneProviderService extends GenericService<PhoneProvider, PhoneProviderDAO> {

    public PhoneProviderService() {
        super(new PhoneProviderDAO());
    }
}
