package controller;

import model.bo.Bairro;
import service.BairroService;
import view.TelaBusBairro;
import view.TelaCadBairro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ControllerCadBairro extends BaseController implements ActionListener {

    TelaCadBairro screen;
    BairroService service;
    public static int codigo;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControllerCadBairro(TelaCadBairro screen) {
        this.screen = screen;
        this.service = new BairroService();

        screen.getjButtonBuscar().addActionListener(this);
        screen.getjButtonNovo().addActionListener(this);
        screen.getjButtonCancelar().addActionListener(this);
        screen.getjButtonGravar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);

        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
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
        Bairro bairro = new Bairro();
        bairro.setDescricaoBairro(this.screen.getNeighborhood().getText());
            
        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
            this.service.salvar(bairro);
        } else {
            bairro.setIdBairro(Integer.parseInt(this.screen.getId().getText()));
            this.service.atualizar(bairro);
        }

        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }
    
    public void search() {
        codigo = 0;
        TelaBusBairro telaBusBairro = new TelaBusBairro(null, true);
        ControllerBusBairro controllerBusBairro = new ControllerBusBairro(telaBusBairro);
        telaBusBairro.setVisible(true);

        if (codigo != 0) {
            Bairro bairro;
            
            bairro = this.service.buscar(codigo);

            creationState(this.screen, true);
            enableFieldsForCreation(this.screen, true);

            this.screen.getId().setText(bairro.getIdBairro() + "");
            this.screen.getNeighborhood().setText(bairro.getDescricaoBairro());

            this.screen.getId().setEnabled(false);
        }
    }
    
    public void exit() {
        screen.dispose();
    }
}
