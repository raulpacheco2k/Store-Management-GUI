package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.BairroDAO;
import br.com.raulpacheco.models.bo.Bairro;

import java.util.List;

public class BairroService implements InterfaceService<Bairro> {

    @Override
    public  void salvar(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.create(objeto);
    }

    @Override
    public List<Bairro> buscar() {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve();
    }

    @Override
    public Bairro buscar(int codigo) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(codigo);
    }

    @Override
    public Bairro buscar(String descricao) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.update(objeto);
    }

    @Override
    public void apagar(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.delete(objeto);
    }

}
