package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ProductDAO;
import br.com.raulpacheco.models.bo.Product;

import java.util.List;

public class ProductService extends GenericService<Product, ProductDAO> {

    public ProductService() {
        super(new ProductDAO());
    }
}
