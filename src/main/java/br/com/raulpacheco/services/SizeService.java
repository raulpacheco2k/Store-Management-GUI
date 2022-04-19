package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.SizeDAO;
import br.com.raulpacheco.models.bo.Size;

import java.util.List;

public class SizeService implements InterfaceService<Size> {

    @Override
    public void salvar(Size objeto) {
        SizeDAO model = new SizeDAO();
        model.create(objeto);
    }

    @Override
    public List<Size> buscar() {
        SizeDAO model = new SizeDAO();
        return model.retrieve();
    }

    @Override
    public Size buscar(int codigo) {
        SizeDAO model = new SizeDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Size buscar(String descricao) {
        SizeDAO model = new SizeDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Size objeto) {
        SizeDAO model = new SizeDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Size objeto) {
        SizeDAO model = new SizeDAO();
        model.delete(objeto);
    }

}
