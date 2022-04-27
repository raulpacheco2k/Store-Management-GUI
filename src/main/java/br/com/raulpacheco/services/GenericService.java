package br.com.raulpacheco.services;

import br.com.raulpacheco.models.DAO.GenericDAO;

import java.util.List;

public class GenericService<Model, Dao extends GenericDAO<Model>> implements InterfaceService<Model> {

    private final Dao dao;

    public GenericService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void store(Model model) {
        this.dao.store(model);
    }

    @Override
    public List<Model> search() {
        return this.dao.search();
    }

    @Override
    public Model search(int id) {
        return this.dao.search(id);
    }

    @Override
    public Model search(String field) {
        return this.dao.search(field);
    }

    @Override
    public void update(Model model) {
        this.dao.update(model);
    }

    @Override
    public void delete(Model model) {
        this.dao.delete(model);
    }
}
