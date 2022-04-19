package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.BrandDAO;
import br.com.raulpacheco.models.bo.Brand;

import java.util.List;

public class BrandService implements InterfaceService<Brand> {

    @Override
    public void salvar(Brand objeto) {
        BrandDAO model = new BrandDAO();
        model.create(objeto);
    }

    @Override
    public List<Brand> buscar() {
        BrandDAO model = new BrandDAO();
        return model.retrieve();
    }

    @Override
    public Brand buscar(int codigo) {
        BrandDAO model = new BrandDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Brand buscar(String descricao) {
        BrandDAO model = new BrandDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Brand objeto) {
        BrandDAO model = new BrandDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Brand objeto) {
        BrandDAO model = new BrandDAO();
        model.delete(objeto);
    }

}
