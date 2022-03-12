package controller;

import model.bo.Color;
import service.ColorService;
import view.TelaBusColor;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusColor implements ActionListener {

    TelaBusColor searchScreen;
    ColorService service = new ColorService();
    DefaultTableModel table;

    public ControllerBusColor(TelaBusColor searchScreen) {
        addListeners(searchScreen);
        this.table = (DefaultTableModel) this.searchScreen.getjTable1().getModel();
        fillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.searchScreen.getjButtonCarregar()) {
            ControllerCadColor.code =
                    (int) this.searchScreen.getjTable1().getValueAt(this.searchScreen.getjTable1().getSelectedRow(), 0);
            this.searchScreen.dispose();
        } else if (e.getSource() == this.searchScreen.getjButtonSair()) {
            this.searchScreen.dispose();
        }
    }

    public void addListeners(TelaBusColor searchScreen) {
        this.searchScreen = searchScreen;
        searchScreen.getjButtonCarregar().addActionListener(this);
        searchScreen.getjButtonSair().addActionListener(this);
    }

    public void fillData() {
        for (Color model : this.service.buscar()) {
            this.table.addRow(new Object[]{
                    model.getId(),
                    model.getDescription(),
            });
        }
    }
}