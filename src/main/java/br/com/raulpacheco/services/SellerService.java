package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.SellerDAO;
import br.com.raulpacheco.models.bo.Seller;

import java.util.List;

public class SellerService extends GenericService<Seller, SellerDAO> {

    public SellerService() {
        super(new SellerDAO());
    }
}
