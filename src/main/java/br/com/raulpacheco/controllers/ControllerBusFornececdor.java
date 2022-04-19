package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Fornecedor;
import br.com.raulpacheco.services.FornecedorService;
import br.com.raulpacheco.views.TelaBusFornecedor;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusFornececdor implements ActionListener {

    TelaBusFornecedor searchScreen;
    FornecedorService service = new FornecedorService();
    DefaultTableModel table;

    public ControllerBusFornececdor(TelaBusFornecedor searchScreen) {
        addListeners(searchScreen);
        this.table = (DefaultTableModel) this.searchScreen.getjTable1().getModel();
        fillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.searchScreen.getjButtonCarregar()) {
            ControllerCadFornecedor.code =
                    (int) this.searchScreen.getjTable1().getValueAt(this.searchScreen.getjTable1().getSelectedRow(), 0);
            this.searchScreen.dispose();
        } else if (e.getSource() == this.searchScreen.getjButtonSair()) {
            this.searchScreen.dispose();
        }
    }

    public void addListeners(TelaBusFornecedor searchScreen) {
        this.searchScreen = searchScreen;
        searchScreen.getjButtonCarregar().addActionListener(this);
        searchScreen.getjButtonSair().addActionListener(this);
    }

    public void fillData() {
        for (Fornecedor model : this.service.buscar()) {
            this.table.addRow(new Object[]{
                    model.getIdFornecedor(),
                    model.getRazaoSocialFornecedor(),
                    model.getCnpjFornecedor()
            });
        }
    }
}