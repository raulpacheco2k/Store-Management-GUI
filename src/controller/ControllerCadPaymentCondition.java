package controller;

import model.bo.PaymentCondition;
import service.PaymentConditionService;
import view.TelaBusPaymentCondition;
import view.TelaCadPaymentCondition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ControllerCadPaymentCondition extends BaseController implements ActionListener {

    TelaCadPaymentCondition screen;
    PaymentConditionService service;
    public static int code = 0;

    public ControllerCadPaymentCondition(TelaCadPaymentCondition screen) {
        this.screen = screen;
        this.service = new PaymentConditionService();
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
        PaymentCondition model = new PaymentCondition();
        model.setConditionDescription(this.screen.getNome().getText());
        model.setDaysUntilFirstInstallment(Integer.parseInt(this.screen.getNumDiasAtePrimeiraParcela().getText()));
        model.setDaysBetweenInstallments(Integer.parseInt(this.screen.getNumDiasEntreParcelas().getText()));

        if (this.screen.getId().getText().trim().equalsIgnoreCase("")) {
            this.service.salvar(model);
        } else {
            model.setId(Integer.parseInt(this.screen.getId().getText()));
            this.service.atualizar(model);
        }

        creationState(this.screen, false);
        enableFieldsForCreation(this.screen, false);
    }

    public void search() {
        TelaBusPaymentCondition telaBusPaymentCondition = new TelaBusPaymentCondition(null, true);
        ControllerBusPaymentCondition controllerBusPaymentCondition = new ControllerBusPaymentCondition(telaBusPaymentCondition);
        telaBusPaymentCondition.setVisible(true);

        if (code != 0) {
            PaymentCondition model;
            model = this.service.buscar(code);
            creationState(this.screen, true);
            enableFieldsForCreation(this.screen, true);

            this.screen.getId().setText(model.getId() + "");
            this.screen.getNome().setText(model.getConditionDescription());
            this.screen.getNumDiasAtePrimeiraParcela().setText(String.valueOf(model.getDaysUntilFirstInstallment()));
            this.screen.getNumDiasEntreParcelas().setText(String.valueOf(model.getDaysBetweenInstallments()));
            this.screen.getId().setEnabled(false);
        }
    }

    public void exit() {
        screen.dispose();
    }
}
