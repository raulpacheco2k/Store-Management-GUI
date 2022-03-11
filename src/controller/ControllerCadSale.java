package controller;

import model.bo.Product;
import model.bo.ProductCharacteristics;
import service.ProductCharacteristicsService;
import service.SaleService;
import view.TelaBusProductCharacteristics;
import view.TelaVendas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public final class ControllerCadSale implements ActionListener {

    TelaVendas screen;
    SaleService service;
    ProductCharacteristicsService productCharacteristicsService;
    public static int codigo;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControllerCadSale(TelaVendas telaVendas) {
        this.screen = telaVendas;
        this.service = new SaleService();

        this.screen.getjButtonBuscaAluno().addActionListener(this);
        this.screen.getjButtonBuscaPersonal().addActionListener(this);
        this.screen.getjButtonBuscaProduto().addActionListener(this);
        this.screen.getjTextFieldBarraProduto().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    // inserirItem();
                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    search();
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                    news();
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
                    exit();
                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
                    store();
                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {

                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
//        if (acao.getSource() == screen.getjButtonNovo()) {
//            news();
//        } else if (acao.getSource() == screen.getjButtonCancelar()) {
//            super.cancel(this.screen);
//        } else if (acao.getSource() == screen.getjButtonGravar()) {
//            store();
//        } else if (acao.getSource() == screen.getjButtonBuscar()) {
//            search();
//        } else if (acao.getSource() == screen.getjButtonSair()) {
//            exit();
//        }
    }

    public void news() {
//        this.screen.getId().setEnabled(false);
    }

    public void store() {
//        Bairro bairro = new Bairro();
//        bairro.setDescricaoBairro(this.screen.getNeighborhood().getText());
//
//        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
//            this.service.salvar(bairro);
//        } else {
//            bairro.setIdBairro(Integer.parseInt(this.screen.getId().getText()));
//            this.service.atualizar(bairro);
//        }
    }

    public void search() {
        codigo = 0;
        TelaBusProductCharacteristics telaBuscaCaracristcaProduto = new TelaBusProductCharacteristics(null, true);
        ControllerBusProductCharacteristics controllerBusProductCharacteristics = new ControllerBusProductCharacteristics(telaBuscaCaracristcaProduto);
        telaBuscaCaracristcaProduto.setVisible(true);

        if (codigo != 0) {
            ProductCharacteristics productCharacteristics;

            productCharacteristics = this.productCharacteristicsService.buscar(codigo);

            // this.screen.getId().setText(bairro.getIdBairro() + "");
            // this.screen.getNeighborhood().setText(bairro.getDescricaoBairro());

            // this.screen.getId().setEnabled(false);
        }
    }

    public void exit() {
        screen.dispose();
    }
}
