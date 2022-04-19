package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.PaymentConditionDAO;
import br.com.raulpacheco.models.bo.PaymentCondition;

import java.util.List;

public class PaymentConditionService implements InterfaceService<PaymentCondition> {

    @Override
    public void salvar(PaymentCondition objeto) {
        PaymentConditionDAO model = new PaymentConditionDAO();
        model.create(objeto);
    }

    @Override
    public List<PaymentCondition> buscar() {
        PaymentConditionDAO model = new PaymentConditionDAO();
        return model.retrieve();
    }

    @Override
    public PaymentCondition buscar(int codigo) {
        PaymentConditionDAO model = new PaymentConditionDAO();
        return model.retrieve(codigo);
    }

    @Override
    public PaymentCondition buscar(String descricao) {
        PaymentConditionDAO model = new PaymentConditionDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(PaymentCondition objeto) {
        PaymentConditionDAO model = new PaymentConditionDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(PaymentCondition objeto) {
        PaymentConditionDAO model = new PaymentConditionDAO();
        model.delete(objeto);
    }

}
