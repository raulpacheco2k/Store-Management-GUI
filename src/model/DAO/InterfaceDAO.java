package model.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
    public abstract void create(T objeto);
    public abstract List<T> retrieve();
    public abstract T retrieve(int codigo);
    public abstract T retrieve(String descricao);
    public abstract void update(T objeto);
    public abstract void delete(T objeto);
}
