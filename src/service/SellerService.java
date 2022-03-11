package service;

import model.DAO.SellerDAO;
import model.bo.Seller;

import java.util.List;

public class SellerService implements InterfaceService<Seller> {

    @Override
    public void salvar(Seller objeto) {
        SellerDAO model = new SellerDAO();
        model.create(objeto);
    }

    @Override
    public List<Seller> buscar() {
        SellerDAO model = new SellerDAO();
        return model.retrieve();
    }

    @Override
    public Seller buscar(int codigo) {
        SellerDAO model = new SellerDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Seller buscar(String descricao) {
        SellerDAO model = new SellerDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Seller objeto) {
        SellerDAO model = new SellerDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Seller objeto) {
        SellerDAO model = new SellerDAO();
        model.delete(objeto);
    }

}
