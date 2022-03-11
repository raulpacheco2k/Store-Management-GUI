package controller;

import model.bo.Client;
import service.ClientService;
import view.TelaBusCliente;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusClient implements ActionListener {

    TelaBusCliente telaBusCliente;

    public ControllerBusClient(TelaBusCliente telaBusCliente) {

        this.telaBusCliente = telaBusCliente;

        telaBusCliente.getjButtonCarregar().addActionListener(this);
        telaBusCliente.getjButtonSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCliente.getjTable1().getModel();

        ClientService clientService = new ClientService();

        for (Client client : clientService.buscar()) {
            tabela.addRow(new Object[]{
                    client.getIdCliente(),
                    client.getNome(),
                    client.getCpfCliente()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBusCliente.getjButtonCarregar()) {
            ControllerCadCliente.codigo = (int) this.telaBusCliente.getjTable1().getValueAt(this.telaBusCliente.getjTable1().getSelectedRow(), 0);
            this.telaBusCliente.dispose();
        } else if (e.getSource() == this.telaBusCliente.getjButtonSair()) {
            this.telaBusCliente.dispose();
        }
    }
}