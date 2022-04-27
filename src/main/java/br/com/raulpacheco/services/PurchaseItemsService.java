package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PurchaseItemsDAO;
import br.com.raulpacheco.models.bo.PurchaseItems;

public class PurchaseItemsService extends GenericService<PurchaseItems, PurchaseItemsDAO> {

    public PurchaseItemsService() {
        super(new PurchaseItemsDAO());
    }
}
