package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import model.bo.Client;
import service.ClientService;
import view.TelaBusCliente;

public class ControllerBusClient implements ActionListener {

    TelaBusCliente telaBusCliente;

    public ControllerBusClient(TelaBusCliente telaBusCliente) {

        this.telaBusCliente = telaBusCliente;

        telaBusCliente.getjButtonCarregar().addActionListener(this);
        telaBusCliente.getjButtonSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCliente.getTable().getModel();

        ClientService clientService = new ClientService();

        for (Client client : clientService.buscar()) {
            tabela.addRow(new Object[]{
                    client.getIdCliente(),
                    client.getNome(),
                    client.getRgCliente()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBusCliente.getjButtonCarregar()) {
            ControllerCadCidade.codigo = (int) this.telaBusCliente.getTable().getValueAt(this.telaBusCliente.getTable().getSelectedRow(), 0);
            this.telaBusCliente.dispose();
        } else if (e.getSource() == this.telaBusCliente.getjButtonSair()) {
            this.telaBusCliente.dispose();
        }
    }
}