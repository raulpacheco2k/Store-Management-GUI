package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PurchaseItemsDAO;
import br.com.raulpacheco.models.bo.PurchaseItems;

import java.util.List;

public class ReceiveService extends GenericService<PurchaseItems, PurchaseItemsDAO> {

    public ReceiveService() {
        super(new PurchaseItemsDAO());
    }
}
