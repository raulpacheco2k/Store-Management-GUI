package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ProductTypeDAO;
import br.com.raulpacheco.models.bo.ProductType;

public class ProductTypeService extends GenericService<ProductType, ProductTypeDAO> {
    public ProductTypeService() {
        super(new ProductTypeDAO());
    }
}
