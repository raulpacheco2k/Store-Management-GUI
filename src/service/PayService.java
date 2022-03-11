package service;

import model.DAO.PayDAO;
import model.bo.Pay;

import java.util.List;

public class PayService implements InterfaceService<Pay> {

    @Override
    public void salvar(Pay objeto) {
        PayDAO model = new PayDAO();
        model.create(objeto);
    }

    @Override
    public List<Pay> buscar() {
        PayDAO model = new PayDAO();
        return model.retrieve();
    }

    @Override
    public Pay buscar(int codigo) {
        PayDAO model = new PayDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Pay buscar(String descricao) {
        PayDAO model = new PayDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Pay objeto) {
        PayDAO model = new PayDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Pay objeto) {
        PayDAO model = new PayDAO();
        model.delete(objeto);
    }

}
