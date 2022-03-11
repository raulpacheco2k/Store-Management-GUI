package service;

import model.DAO.PurchaseDAO;
import model.bo.Purchase;

import java.util.List;

public class PurchaseService implements InterfaceService<Purchase> {

    @Override
    public void salvar(Purchase objeto) {
        PurchaseDAO model = new PurchaseDAO();
        model.create(objeto);
    }

    @Override
    public List<Purchase> buscar() {
        PurchaseDAO model = new PurchaseDAO();
        return model.retrieve();
    }

    @Override
    public Purchase buscar(int codigo) {
        PurchaseDAO model = new PurchaseDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Purchase buscar(String descricao) {
        PurchaseDAO model = new PurchaseDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Purchase objeto) {
        PurchaseDAO model = new PurchaseDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Purchase objeto) {
        PurchaseDAO model = new PurchaseDAO();
        model.delete(objeto);
    }

}
