package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ProductTypeDAO;
import br.com.raulpacheco.models.bo.ProductType;

import java.util.List;

public class ProductTypeService implements InterfaceService<ProductType> {

    @Override
    public void salvar(ProductType objeto) {
        ProductTypeDAO model = new ProductTypeDAO();
        model.create(objeto);
    }

    @Override
    public List<ProductType> buscar() {
        ProductTypeDAO model = new ProductTypeDAO();
        return model.retrieve();
    }

    @Override
    public ProductType buscar(int codigo) {
        ProductTypeDAO model = new ProductTypeDAO();
        return model.retrieve(codigo);
    }

    @Override
    public ProductType buscar(String descricao) {
        ProductTypeDAO model = new ProductTypeDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(ProductType objeto) {
        ProductTypeDAO model = new ProductTypeDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(ProductType objeto) {
        ProductTypeDAO model = new ProductTypeDAO();
        model.delete(objeto);
    }

}
