package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PurchaseDAO;
import br.com.raulpacheco.models.bo.Purchase;

import java.util.List;

public class PurchaseService extends GenericService<Purchase, PurchaseDAO> {

    public PurchaseService() {
        super(new PurchaseDAO());
    }
}
