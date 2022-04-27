package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Color;
import br.com.raulpacheco.services.ColorService;
import br.com.raulpacheco.views.TelaBusColor;
import br.com.raulpacheco.views.TelaCadColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ControllerCadColor extends BaseController implements ActionListener {

    TelaCadColor screen;
    ColorService service;
    public static int code = 0;

    public ControllerCadColor(TelaCadColor screen) {
        this.screen = screen;
        this.service = new ColorService();
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
        Color model = new Color();
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
        TelaBusColor searchScreen = new TelaBusColor(null, true);
        ControllerBusColor controllerSearch = new ControllerBusColor(searchScreen);
        searchScreen.setVisible(true);

        if (code != 0) {
            Color model;
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
