package br.com.raulpacheco.services;

import java.util.List;

public interface InterfaceService<Model> {
    public abstract void store(Model model);

    public abstract List<Model> search();

    public abstract Model search(int id);

    public abstract Model search(String field);

    public abstract void update(Model model);

    public abstract void delete(Model model);
}
