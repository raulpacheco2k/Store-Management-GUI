package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ProductDAO;
import br.com.raulpacheco.models.bo.Product;

import java.util.List;

public class ProductService implements InterfaceService<Product> {

    @Override
    public void salvar(Product objeto) {
        ProductDAO model = new ProductDAO();
        model.create(objeto);
    }

    @Override
    public List<Product> buscar() {
        ProductDAO model = new ProductDAO();
        return model.retrieve();
    }

    @Override
    public Product buscar(int codigo) {
        ProductDAO model = new ProductDAO();
        return model.retrieve(codigo);
    }

    @Override
    public Product buscar(String descricao) {
        ProductDAO model = new ProductDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(Product objeto) {
        ProductDAO model = new ProductDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(Product objeto) {
        ProductDAO model = new ProductDAO();
        model.delete(objeto);
    }

}
