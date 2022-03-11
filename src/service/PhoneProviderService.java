package service;

import model.DAO.PhoneProviderDAO;
import model.bo.PhoneProvider;

import java.util.List;

public class PhoneProviderService implements InterfaceService<PhoneProvider> {

    @Override
    public void salvar(PhoneProvider objeto) {
        PhoneProviderDAO model = new PhoneProviderDAO();
        model.create(objeto);
    }

    @Override
    public List<PhoneProvider> buscar() {
        PhoneProviderDAO model = new PhoneProviderDAO();
        return model.retrieve();
    }

    @Override
    public PhoneProvider buscar(int codigo) {
        PhoneProviderDAO model = new PhoneProviderDAO();
        return model.retrieve(codigo);
    }

    @Override
    public PhoneProvider buscar(String descricao) {
        PhoneProviderDAO model = new PhoneProviderDAO();
        return model.retrieve(descricao);
    }

    @Override
    public void atualizar(PhoneProvider objeto) {
        PhoneProviderDAO model = new PhoneProviderDAO();
        model.update(objeto);
    }

    @Override
    public void apagar(PhoneProvider objeto) {
        PhoneProviderDAO model = new PhoneProviderDAO();
        model.delete(objeto);
    }

}
