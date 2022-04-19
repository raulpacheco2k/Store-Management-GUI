package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Bairro;
import br.com.raulpacheco.models.bo.Cidade;
import br.com.raulpacheco.models.bo.Endereco;
import br.com.raulpacheco.services.AddressService;
import br.com.raulpacheco.services.BairroService;
import br.com.raulpacheco.services.CidadeService;;
import br.com.raulpacheco.views.TelaBusAddress;
import br.com.raulpacheco.views.TelaCadEndereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ControllerCadAddress extends BaseController implements ActionListener {

    TelaCadEndereco screen;
    AddressService service;
    BairroService bairroService;
    CidadeService cidadeService;
    public static int codigo;

    public ControllerCadAddress() {
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControllerCadAddress(TelaCadEndereco screen) {
        this.screen = screen;
        this.service = new AddressService();
        this.bairroService = new BairroService();
        this.cidadeService = new CidadeService();

        screen.getjButtonBuscar().addActionListener(this);
        screen.getjButtonNovo().addActionListener(this);
        screen.getjButtonCancelar().addActionListener(this);
        screen.getjButtonGravar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);

        super.creationState(this.screen, false);
        super.enableFieldsForCreation(this.screen, false);
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == screen.getjButtonNovo()) {
            news();
        } else if (acao.getSource() == screen.getjButtonCancelar()) {
            super.cancel(this.screen);
        } else if (acao.getSource() == screen.getjButtonGravar()) {
            store();
        } else if (acao.getSource() == screen.getjButtonBuscar()) {
            search();
        } else if (acao.getSource() == screen.getjButtonSair()) {
            exit();
        }
    }

    public void news() {
        super.creationState(this.screen, true);
        super.enableFieldsForCreation(this.screen, true);
        this.screen.getId().setEnabled(false);
    }

    public void store() {
        Endereco address = new Endereco();
        address.setCepCep(this.screen.getZipCode().getText());
        address.setLogradouroCep(this.screen.getStreet().getText());
        address.setBairro(
                this.bairroService.buscar(
                        ((Bairro) Objects.requireNonNull(this.screen.getNeighborhood().getSelectedItem())).getIdBairro()

                ));
        address.setCidade(
                this.cidadeService.buscar(
                        ((Cidade) Objects.requireNonNull(this.screen.getCity().getSelectedItem())).getIdCidade()
                ));


        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
            this.service.salvar(address);
        } else {
            address.setIdCep(Integer.parseInt(this.screen.getId().getText()));
            this.service.atualizar(address);
        }
        super.creationState(this.screen, false);
        super.enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        codigo = 0;
        TelaBusAddress telaBusAddress = new TelaBusAddress(null, true);
        ControllerBusAddress controllerBusAddress = new ControllerBusAddress(telaBusAddress);
        telaBusAddress.setVisible(true);

        if (codigo != 0) {
            Endereco endereco = this.service.buscar(codigo);

            super.creationState(this.screen, true);
            super.enableFieldsForCreation(this.screen, true);

            this.screen.getId().setText(endereco.getIdCep() + "");
            this.screen.getZipCode().setText(endereco.getCepCep());
            this.screen.getStreet().setText(endereco.getLogradouroCep());
            this.screen.getNeighborhood().getModel().setSelectedItem(endereco.getBairro());
            this.screen.getCity().getModel().setSelectedItem(endereco.getCidade());

            this.screen.getId().setEnabled(false);
        }
    }

    public static Endereco busca(int id) {
        AddressService addressService = new AddressService();
        return addressService.buscar(id);
    }

    public void exit() {
        screen.dispose();
    }
}
