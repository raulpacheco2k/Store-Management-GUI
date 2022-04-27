package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PaymentConditionDAO;
import br.com.raulpacheco.models.bo.PaymentCondition;

public class PaymentConditionService extends GenericService<PaymentCondition, PaymentConditionDAO> {

    public PaymentConditionService() {
        super(new PaymentConditionDAO());
    }
}
