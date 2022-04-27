package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PayDAO;
import br.com.raulpacheco.models.bo.Pay;

public class PayService extends GenericService<Pay, PayDAO> {
    public PayService() {
        super(new PayDAO());
    }
}
