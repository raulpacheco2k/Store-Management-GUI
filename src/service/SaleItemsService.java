package service;

import model.DAO.PurchaseItemsDAO;
import model.bo.PurchaseItems;

import java.util.List;

public class SaleItemsService implements InterfaceService<PurchaseItems> {

    @Override
    public void salvar(PurchaseItems objeto) {
        PurchaseItemsDAO model = new PurchaseItemsDAO();
        model.create(objeto);
    }

    @Override
    public List<PurchaseItems> buscar() {
        PurchaseItemsDAO model = new PurchaseItemsDAO();
        return model.retrieve();
    }

    @Override
    public PurchaseItems buscar(int codigo) {
        PurchaseItemsDAO model = new PurchaseItemsDAO();
        return model.retrieve(codigo);
    }

    @Override
    public PurchaseItems buscar(String descricao) {
        PurchaseItemsDAO model = new PurchaseItemsDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(PurchaseItems objeto) {
        PurchaseItemsDAO model = new PurchaseItemsDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(PurchaseItems objeto) {
        PurchaseItemsDAO model = new PurchaseItemsDAO();
        model.delete(objeto);
    }

}
