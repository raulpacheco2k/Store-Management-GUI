package controller;

import model.bo.Product;
import model.bo.ProductCharacteristics;
import service.ProductCharacteristicsService;
import view.TelaBusProductCharacteristics;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusProductCharacteristics implements ActionListener {

    TelaBusProductCharacteristics screen;

    public ControllerBusProductCharacteristics(TelaBusProductCharacteristics screen) {

        this.screen = screen;

        screen.getjButtonCarregar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.screen.getjTable1().getModel();

        ProductCharacteristicsService cidadeService = new ProductCharacteristicsService();

        for (ProductCharacteristics model : cidadeService.buscar()) {
            tabela.addRow(new Object[]{
                    model.getBarCode()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.screen.getjButtonCarregar()) {
            ControllerCadSale.codigo =
                    (int) this.screen.getjTable1().getValueAt(this.screen.getjTable1().getSelectedRow(), 0);
            this.screen.dispose();
        } else if (e.getSource() == this.screen.getjButtonSair()) {
            this.screen.dispose();
        }
    }
}