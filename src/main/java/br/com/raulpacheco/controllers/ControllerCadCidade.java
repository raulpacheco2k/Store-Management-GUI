package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Cidade;
import br.com.raulpacheco.services.CidadeService;;
import br.com.raulpacheco.views.TelaBusCidade;
import br.com.raulpacheco.views.TelaCadCidade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadCidade extends BaseController implements ActionListener {

    TelaCadCidade screen;
    CidadeService service;
    public static int id;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControllerCadCidade(TelaCadCidade screen) {
        this.screen = screen;
        this.service = new CidadeService();

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
        creationState(this.screen, true);
        enableFieldsForCreation(this.screen, true);
        this.screen.getjTFIdCidade().setEnabled(false);
    }

    public void store() {
        Cidade cidade = new Cidade();
        cidade.setDescricaoCidade(this.screen.getjTFNomeCidade().getText());
        cidade.setUfCidade(this.screen.getjTFUF().getText());

        if (this.screen.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
            this.service.store(cidade);
        } else {
            cidade.setIdCidade(Integer.parseInt(this.screen.getjTFIdCidade().getText()));
            this.service.update(cidade);
        }
        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        id = 0;
        TelaBusCidade telaBusCidade = new TelaBusCidade(null, true);
        ControllerBusCidade controllerBusCidade = new ControllerBusCidade(telaBusCidade);
        telaBusCidade.setVisible(true);

        if (id != 0) {
            Cidade cidade = this.service.search(id);

            creationState(this.screen, true);
            enableFieldsForCreation(this.screen, true);

            this.screen.getjTFIdCidade().setText(cidade.getIdCidade() + "");
            this.screen.getjTFNomeCidade().setText(cidade.getDescricaoCidade());
            this.screen.getjTFUF().setText(cidade.getUfCidade());

            this.screen.getjTFIdCidade().setEnabled(false);
        }
    }

    public void exit() {
        screen.dispose();
    }
}
