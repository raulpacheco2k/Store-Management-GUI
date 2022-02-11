package service;

import java.util.List;
import model.DAO.ClientDAO;
import model.bo.Client;

public class ClientService implements InterfaceService<Client> {

    @Override
    public  void salvar(Client objeto) {
        ClientDAO ClientDAO = new ClientDAO();
        ClientDAO.create(objeto);
    }

    @Override
    public List<Client> buscar() {
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.retrieve();
    }

    @Override
    public Client buscar(int codigo) {
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.retrieve(codigo);
    }

    @Override
    public Client buscar(String descricao) {
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Client objeto) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.update(objeto);
    }

    @Override
    public void apagar(Client objeto) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.delete(objeto);
    }

}
