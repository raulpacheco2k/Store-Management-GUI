package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Client;
import br.com.raulpacheco.services.AddressService;
import br.com.raulpacheco.services.ClientService;
import br.com.raulpacheco.views.TelaBusCliente;
import br.com.raulpacheco.views.TelaCadCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerCadCliente extends BaseController implements ActionListener {

    TelaCadCliente screen;
    ControllerCadAddress controllerCadAddress = new ControllerCadAddress();
    AddressService addressService = new AddressService();
    public static int codigo;

    public ControllerCadCliente(TelaCadCliente screen) {
        this.screen = screen;

        screen.getjButtonBuscar().addActionListener(this);
        screen.getjButtonNovo().addActionListener(this);
        screen.getjButtonCancelar().addActionListener(this);
        screen.getjButtonGravar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);

        this.screen.getBuscarCep().setEnabled(false);
        this.screen.getComplement().setEnabled(false);
        this.screen.getEstado().setEnabled(false);
        this.screen.getCidade().setEnabled(false);
        this.screen.getBairro().setEnabled(false);
        super.creationState(this.screen, false);
        super.enableFieldsForCreation(this.screen, false);
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.screen.getjButtonNovo()) {
            news();
        } else if (acao.getSource() == this.screen.getjButtonCancelar()) {
            super.cancel(screen);
        } else if (acao.getSource() == this.screen.getjButtonGravar()) {
            store();
        } else if (acao.getSource() == this.screen.getjButtonBuscar()) {
            search();
        } else if (acao.getSource() == this.screen.getjButtonSair()) {
            exit();
        }
    }

    public void news() {
        creationState(this.screen, true);
        enableFieldsForCreation(this.screen, true);
        this.screen.getId().setEnabled(false);
        this.screen.getComplement().setEnabled(true);

        this.screen.getBuscarCep().setEnabled(true);
        this.screen.getBairro().setEnabled(false);
        this.screen.getCidade().setEnabled(false);
        this.screen.getEstado().setEnabled(false);
    }

    public void store() {
        Client client = new Client();
        client.setNome(this.screen.getFullName().getText());

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            client.setDtNasc(dateFormat.parse(this.screen.getDateOfBirth().getText()));
        } catch (ParseException ex) {
            Logger.getLogger(ControllerCadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        client.setRgCliente(this.screen.getDocument_rg().getText());
        client.setCpfCliente(this.screen.getDocument_cpf().getText());
        client.setFoneCliente(this.screen.getTelephone_1().getText());
        client.setFone2Cliente(this.screen.getTelephone_2().getText());
        client.setEmail(this.screen.getEmail().getText());
        client.setEndereco(this.addressService.buscar(this.screen.getCep().getText()));
        client.setCompleEndereco(this.screen.getComplement().getText());

        ClientService clientService = new ClientService();

        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
            clientService.salvar(client);
        } else {
            client.setIdCliente(Integer.parseInt(this.screen.getId().getText()));
            clientService.atualizar(client);
        }

        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        TelaBusCliente telaBusCliente = new TelaBusCliente(null, true);
        ControllerBusClient controllerBusClient = new ControllerBusClient(telaBusCliente);
        telaBusCliente.setVisible(true);
        this.screen.getComplement().setEnabled(true);


        if (codigo != 0) {
            Client client;
            ClientService clientService = new ClientService();
            client = clientService.buscar(codigo);

            creationState(this.screen, true);
            enableFieldsForCreation(this.screen, true);

            this.screen.getId().setText(client.getIdCliente() + "");
            this.screen.getFullName().setText(client.getNome());
            this.screen.getDocument_cpf().setText(client.getCpfCliente());
            this.screen.getDocument_rg().setText(client.getRgCliente());
            this.screen.getTelephone_1().setText(client.getFoneCliente());
            this.screen.getTelephone_2().setText(client.getFone2Cliente());
            this.screen.getEmail().setText(client.getEmail());
            this.screen.getComplement().setText(client.getCompleEndereco());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.screen.getDateOfBirth().setText(format.format(client.getDtNasc()));
            String cep = this.addressService.buscar(client.getIdEndereco()).getCepCep();
            this.screen.getCep().setText(cep);
            this.screen.getCep().setText(cep);

            this.screen.getCep().setEnabled(true);
            this.screen.getBuscarCep().setEnabled(true);
            this.screen.getBairro().setEnabled(false);
            this.screen.getCidade().setEnabled(false);
            this.screen.getEstado().setEnabled(false);
            this.screen.getId().setEnabled(false);
        }
    }

    public void exit() {
        screen.dispose();
    }
}
