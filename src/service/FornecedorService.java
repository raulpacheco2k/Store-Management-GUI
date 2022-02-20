package service;

import model.DAO.FornecedorDAO;
import model.bo.Fornecedor;

import java.util.List;

public class FornecedorService implements InterfaceService<Fornecedor> {

    @Override
    public void salvar(Fornecedor objeto) {
        FornecedorDAO address = new FornecedorDAO();
        address.create(objeto);
    }

    @Override
    public List<Fornecedor> buscar() {
        FornecedorDAO address = new FornecedorDAO();
        return address.retrieve();
    }

    @Override
    public Fornecedor buscar(int codigo) {
        FornecedorDAO address = new FornecedorDAO();
        return address.retrieve(codigo);
    }

    @Override
    public Fornecedor buscar(String descricao) {
        FornecedorDAO address = new FornecedorDAO();
        return address.retrieve(descricao);
    }

    @Override
    public void atualizar(Fornecedor objeto) {
        FornecedorDAO address = new FornecedorDAO();
        address.update(objeto);
    }

    @Override
    public void apagar(Fornecedor objeto) {
        FornecedorDAO address = new FornecedorDAO();
        address.delete(objeto);
    }

}
