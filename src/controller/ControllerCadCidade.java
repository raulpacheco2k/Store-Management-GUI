package controller;

import static controller.ControllerCadCidade.codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bo.Cidade;
import service.CidadeService;
import view.TelaBusCidade;
import view.TelaCadCidade;

public class ControllerCadCidade extends BaseController implements ActionListener {

    TelaCadCidade screen;
    public static int codigo;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControllerCadCidade(TelaCadCidade screen) {
        this.screen = screen;

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
        CidadeService cidSevice = new CidadeService();

        if (this.screen.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
            cidSevice.salvar(cidade);
        } else {
            cidade.setIdCidade(Integer.parseInt(this.screen.getjTFIdCidade().getText()));
            cidSevice.atualizar(cidade);
        }
        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        codigo = 0;
        TelaBusCidade telaBusCidade = new TelaBusCidade(null, true);
        ControllerBusCidade controllerBusCidade = new ControllerBusCidade(telaBusCidade);
        telaBusCidade.setVisible(true);

        if (codigo != 0) {
            Cidade cidade;
            CidadeService cidadeService = new CidadeService();
            cidade = cidadeService.buscar(codigo);

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
