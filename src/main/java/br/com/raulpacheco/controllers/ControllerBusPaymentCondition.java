package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.PaymentCondition;
import br.com.raulpacheco.services.PaymentConditionService;
import br.com.raulpacheco.views.TelaBusPaymentCondition;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusPaymentCondition implements ActionListener {

    TelaBusPaymentCondition searchScreen;
    PaymentConditionService service = new PaymentConditionService();
    DefaultTableModel table;

    public ControllerBusPaymentCondition(TelaBusPaymentCondition searchScreen) {
        this.searchScreen = searchScreen;
        this.table = (DefaultTableModel) this.searchScreen.getjTable1().getModel();
        addListeners(searchScreen);
        fillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.searchScreen.getjButtonCarregar()) {
            ControllerCadPaymentCondition.code =
                    (int) this.searchScreen.getjTable1().getValueAt(this.searchScreen.getjTable1().getSelectedRow(), 0);
            this.searchScreen.dispose();
        } else if (e.getSource() == this.searchScreen.getjButtonSair()) {
            this.searchScreen.dispose();
        }
    }

    public void addListeners(TelaBusPaymentCondition searchScreen) {
        searchScreen.getjButtonCarregar().addActionListener(this);
        searchScreen.getjButtonSair().addActionListener(this);
    }

    public void fillData() {
        for (PaymentCondition model : this.service.buscar()) {
            this.table.addRow(new Object[]{
                    model.getId(),
                    model.getConditionDescription(),
                    model.getDaysUntilFirstInstallment(),
                    model.getDaysBetweenInstallments(),
            });
        }
    }
}