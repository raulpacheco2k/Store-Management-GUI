package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.ColorDAO;
import br.com.raulpacheco.models.bo.Color;

public class ColorService extends GenericService<Color, ColorDAO> {
    public ColorService() {
        super(new ColorDAO());
    }
}
