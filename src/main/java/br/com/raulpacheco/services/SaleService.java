package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.SaleDAO;
import br.com.raulpacheco.models.bo.Sale;

public class SaleService extends GenericService<Sale, SaleDAO> {
    public SaleService() {
        super(new SaleDAO());
    }
}
