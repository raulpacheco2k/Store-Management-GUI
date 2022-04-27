package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.BrandDAO;
import br.com.raulpacheco.models.bo.Brand;

public class BrandService extends GenericService<Brand, BrandDAO> {
    public BrandService() {
        super(new BrandDAO());
    }
}
