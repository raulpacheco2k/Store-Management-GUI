package controller;

import model.bo.Endereco;
import service.AddressService;
import view.TelaBusAddress;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusAddress implements ActionListener {

    TelaBusAddress telaBusBairro;
    AddressService addressService = new AddressService();
    DefaultTableModel table;

    public ControllerBusAddress(TelaBusAddress telaBusBairro) {
        addListeners(telaBusBairro);
        this.table = (DefaultTableModel) this.telaBusBairro.getjTable1().getModel();
        fillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBusBairro.getjButtonCarregar()) {
            ControllerCadAddress.codigo =
                    (int) this.telaBusBairro.getjTable1().getValueAt(this.telaBusBairro.getjTable1().getSelectedRow(), 0);
            this.telaBusBairro.dispose();
        } else if (e.getSource() == this.telaBusBairro.getjButtonSair()) {
            this.telaBusBairro.dispose();
        }
    }

    public void addListeners(TelaBusAddress telaBusBairro) {
        this.telaBusBairro = telaBusBairro;
        telaBusBairro.getjButtonCarregar().addActionListener(this);
        telaBusBairro.getjButtonSair().addActionListener(this);
    }

    public void fillData() {
        for (Endereco endereco : this.addressService.buscar()) {
            this.table.addRow(new Object[]{
                    endereco.getIdCep(),
                    endereco.getCepCep(),
                    endereco.getCidade(),
                    endereco.getBairro(),
                    endereco.getLogradouroCep()
            });
        }
    }
}