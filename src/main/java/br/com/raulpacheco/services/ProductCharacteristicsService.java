package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ProductCharacteristicsDAO;
import br.com.raulpacheco.models.bo.ProductCharacteristics;

public class ProductCharacteristicsService extends GenericService<ProductCharacteristics, ProductCharacteristicsDAO> {
    public ProductCharacteristicsService() {
        super(new ProductCharacteristicsDAO());
    }
}
