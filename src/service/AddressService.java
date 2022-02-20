package service;

import model.DAO.AddressDAO;
import model.bo.Endereco;

import java.util.List;

public class AddressService implements InterfaceService<Endereco> {

    @Override
    public void salvar(Endereco objeto) {
        AddressDAO address = new AddressDAO();
        address.create(objeto);
    }

    @Override
    public List<Endereco> buscar() {
        AddressDAO address = new AddressDAO();
        return address.retrieve();
    }

    @Override
    public Endereco buscar(int codigo) {
        AddressDAO address = new AddressDAO();
        return address.retrieve(codigo);
    }

    @Override
    public Endereco buscar(String descricao) {
        AddressDAO address = new AddressDAO();
        return address.retrieve(descricao);
    }

    @Override
    public void atualizar(Endereco objeto) {
        AddressDAO address = new AddressDAO();
        address.update(objeto);
    }

    @Override
    public void apagar(Endereco objeto) {
        AddressDAO address = new AddressDAO();
        address.delete(objeto);
    }

}
