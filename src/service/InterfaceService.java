package service;

import java.util.List;
public interface InterfaceService<T> {
    public abstract  void salvar(T objeto);
    public abstract List<T> buscar();
    public abstract T buscar(int codigo);
    public abstract T buscar(String descricao);
    public abstract void atualizar(T objeto);
    public abstract void apagar(T objeto);
}
