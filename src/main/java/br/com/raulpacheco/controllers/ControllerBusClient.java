package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Client;
import br.com.raulpacheco.services.ClientService;
import br.com.raulpacheco.views.TelaBusCliente;

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

        for (Client client : clientService.search()) {
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