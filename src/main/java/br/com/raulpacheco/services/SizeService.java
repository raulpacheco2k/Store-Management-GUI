package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.SizeDAO;
import br.com.raulpacheco.models.bo.Size;

public class SizeService extends GenericService<Size, SizeDAO> {
    public SizeService() {
        super(new SizeDAO());
    }
}
