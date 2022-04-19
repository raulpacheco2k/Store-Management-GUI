package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ColorDAO;
import br.com.raulpacheco.models.bo.Color;

import java.util.List;

public class ColorService implements InterfaceService<Color> {

    @Override
    public void salvar(Color objeto) {
        ColorDAO model = new ColorDAO();
        model.create(objeto);
    }

    @Override
    public List<Color> buscar() {
        ColorDAO model = new ColorDAO();
        return model.retrieve();
    }

    @Override
    public Color buscar(int codigo) {
        ColorDAO model = new ColorDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Color buscar(String descricao) {
        ColorDAO model = new ColorDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Color objeto) {
        ColorDAO model = new ColorDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Color objeto) {
        ColorDAO model = new ColorDAO();
        model.delete(objeto);
    }

}
