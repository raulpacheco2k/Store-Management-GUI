package controller;

import model.bo.Endereco;
import model.bo.Fornecedor;
import service.AddressService;
import service.FornecedorService;
import service.FornecedorService;
import view.TelaBusFornecedor;
import view.TelaCadFornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ControllerCadFornecedor extends BaseController implements ActionListener {

    TelaCadFornecedor screen;
    FornecedorService service;
    AddressService addressService;
    public static int code;

    public ControllerCadFornecedor() {
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public ControllerCadFornecedor(TelaCadFornecedor screen) {
        this.screen = screen;
        this.service = new FornecedorService();
        this.addressService = new AddressService();

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
        Fornecedor fornecedor = new Fornecedor(
                this.screen.getRazaoSocial().getText(),
                this.screen.getCnpj().getText(),
                this.screen.getInscricaoEstadual().getText(),
                this.screen.getNomeFantasia().getText(),
                this.screen.getEmail().getText(),
                this.screen.getCompleto().getText(),
                this.addressService.buscar(((Endereco) Objects.requireNonNull(this.screen.getCep().getSelectedItem())).getIdCep())
        );

        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
            this.service.salvar(fornecedor);
        } else {
            fornecedor.setIdFornecedor(Integer.parseInt(this.screen.getId().getText()));
            this.service.atualizar(fornecedor);
        }
        super.creationState(this.screen, false);
        super.enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        TelaBusFornecedor telaBusFornecedor = new TelaBusFornecedor(null, true);
        ControllerBusFornececdor controllerBusFornecedor = new ControllerBusFornececdor(telaBusFornecedor);
        telaBusFornecedor.setVisible(true);

        if (code != 0) {
            Fornecedor model;

            model = this.service.buscar(code);

            super.creationState(this.screen, true);
            super.enableFieldsForCreation(this.screen, true);

            this.screen.getId().setText(model.getIdFornecedor() + "");
            this.screen.getNomeFantasia().setText(model.getNome());
            this.screen.getRazaoSocial().setText(model.getRazaoSocialFornecedor());
            this.screen.getCnpj().setText(model.getCnpjFornecedor());
            this.screen.getCompleto().setText(model.getCompleEndereco());
            this.screen.getInscricaoEstadual().setText(model.getInscEstadualFornecedor());
            this.screen.getEmail().setText(model.getEmail());
            this.screen.getCep().getModel().setSelectedItem(model.getEndereco());

            this.screen.getId().setEnabled(false);
        }
    }

    public Fornecedor busca(int id) {
        return this.service.buscar(id);
    }

    public void exit() {
        screen.dispose();
    }
}
