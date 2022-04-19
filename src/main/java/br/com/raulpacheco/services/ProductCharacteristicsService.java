package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ProductCharacteristicsDAO;
import br.com.raulpacheco.models.bo.ProductCharacteristics;

import java.util.List;

public class ProductCharacteristicsService implements InterfaceService<ProductCharacteristics> {

    @Override
    public void salvar(ProductCharacteristics objeto) {
        ProductCharacteristicsDAO objectDao = new ProductCharacteristicsDAO();
        objectDao.create(objeto);
    }

    @Override
    public List<ProductCharacteristics> buscar() {
        ProductCharacteristicsDAO objectDao = new ProductCharacteristicsDAO();
        return objectDao.retrieve();
    }

    @Override
    public ProductCharacteristics buscar(int codigo) {
        ProductCharacteristicsDAO objectDao = new ProductCharacteristicsDAO();
        return objectDao.retrieve(codigo);
    }

    @Override
    public ProductCharacteristics buscar(String descricao) {
        ProductCharacteristicsDAO objectDao = new ProductCharacteristicsDAO();
        return objectDao.retrieve(descricao);
    }

    @Override
    public void atualizar(ProductCharacteristics objeto) {
        ProductCharacteristicsDAO objectDao = new ProductCharacteristicsDAO();
        objectDao.update(objeto);
    }

    @Override
    public void apagar(ProductCharacteristics objeto) {
        ProductCharacteristicsDAO objectDao = new ProductCharacteristicsDAO();
        objectDao.delete(objeto);
    }
}
