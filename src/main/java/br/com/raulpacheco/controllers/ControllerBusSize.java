package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Size;
import br.com.raulpacheco.services.SizeService;
import br.com.raulpacheco.views.TelaBusSize;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusSize implements ActionListener {

    TelaBusSize telaBusBairro;
    SizeService addressService = new SizeService();
    DefaultTableModel table;

    public ControllerBusSize(TelaBusSize searchScreen) {
        addListeners(searchScreen);
        this.table = (DefaultTableModel) this.telaBusBairro.getjTable1().getModel();
        fillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBusBairro.getjButtonCarregar()) {
            ControllerCadSize.code =
                    (int) this.telaBusBairro.getjTable1().getValueAt(this.telaBusBairro.getjTable1().getSelectedRow(), 0);
            this.telaBusBairro.dispose();
        } else if (e.getSource() == this.telaBusBairro.getjButtonSair()) {
            this.telaBusBairro.dispose();
        }
    }

    public void addListeners(TelaBusSize telaBusBairro) {
        this.telaBusBairro = telaBusBairro;
        telaBusBairro.getjButtonCarregar().addActionListener(this);
        telaBusBairro.getjButtonSair().addActionListener(this);
    }

    public void fillData() {
        for (Size model : this.addressService.buscar()) {
            this.table.addRow(new Object[]{
                    model.getId(),
                    model.getDescription(),
            });
        }
    }
}