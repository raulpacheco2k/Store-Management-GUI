package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.SaleDAO;
import br.com.raulpacheco.models.bo.Sale;

import java.util.List;

public class SaleService implements InterfaceService<Sale> {

    @Override
    public void salvar(Sale objeto) {
        SaleDAO saleDAO = new SaleDAO();
        saleDAO.create(objeto);
    }

    @Override
    public List<Sale> buscar() {
        SaleDAO clientDAO = new SaleDAO();
        return clientDAO.retrieve();
    }

    @Override
    public Sale buscar(int codigo) {
        SaleDAO clientDAO = new SaleDAO();
        return clientDAO.retrieve(codigo);
    }

    @Override
    public Sale buscar(String descricao) {
        SaleDAO clientDAO = new SaleDAO();
        return clientDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Sale objeto) {
        SaleDAO clientDAO = new SaleDAO();
        clientDAO.update(objeto);
    }

    @Override
    public void apagar(Sale objeto) {
        SaleDAO clientDAO = new SaleDAO();
        clientDAO.delete(objeto);
    }
}
