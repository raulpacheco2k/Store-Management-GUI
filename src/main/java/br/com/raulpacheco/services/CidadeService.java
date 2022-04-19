package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.CidadeDAO;
import br.com.raulpacheco.models.bo.Cidade;

import java.util.List;

public class CidadeService implements InterfaceService<Cidade> {

    @Override
    public void salvar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.create(objeto);
    }

    @Override
    public List<Cidade> buscar() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve();
    }

    @Override
    public Cidade buscar(int codigo) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(codigo);
    }

    @Override
    public Cidade buscar(String descricao) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(objeto);
    }

    @Override
    public void apagar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(objeto);
    }

}
