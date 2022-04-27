package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.ProductType;
import br.com.raulpacheco.services.ProductTypeService;
import br.com.raulpacheco.views.TelaBusProductType;
import br.com.raulpacheco.views.TelaCadProductType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ControllerCadProductType extends BaseController implements ActionListener {

    TelaCadProductType screen;
    ProductTypeService service;
    public static int code = 0;

    public ControllerCadProductType(TelaCadProductType screen) {
        this.screen = screen;
        this.service = new ProductTypeService();
        addListener();
        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }

    public void addListener() {
        screen.getjButtonBuscar().addActionListener(this);
        screen.getjButtonNovo().addActionListener(this);
        screen.getjButtonCancelar().addActionListener(this);
        screen.getjButtonGravar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);
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
        creationState(this.screen, true);
        enableFieldsForCreation(this.screen, true);
        this.screen.getId().setEnabled(false);
    }

    public void store() {
        ProductType model = new ProductType();
        model.setDescription(this.screen.getNome().getText());

        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
            this.service.store(model);
        } else {
            model.setId(Integer.parseInt(this.screen.getId().getText()));
            this.service.update(model);
        }

        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        TelaBusProductType telaBusProductType = new TelaBusProductType(null, true);
        ControllerBusProductType controllerBusProductType = new ControllerBusProductType(telaBusProductType);
        telaBusProductType.setVisible(true);

        if (code != 0) {
            ProductType model;
            model = this.service.search(code);

            creationState(this.screen, true);
            enableFieldsForCreation(this.screen, true);

            this.screen.getId().setText(model.getId() + "");
            this.screen.getNome().setText(model.getDescription());
            this.screen.getId().setEnabled(false);
        }
    }

    public void exit() {
        screen.dispose();
    }
}
