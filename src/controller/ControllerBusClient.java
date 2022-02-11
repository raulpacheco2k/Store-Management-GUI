package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Client;
import service.ClientService;
import view.TelaBusCliente;
public class ControllerBusClient implements ActionListener{
    
    TelaBusCliente telaBusCliente;

    public ControllerBusClient(TelaBusCliente telaBusCliente) {
        
        this.telaBusCliente = telaBusCliente;
        
        telaBusCliente.getjButtonCarregar().addActionListener(this);
        telaBusCliente.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCliente.getjTable1().getModel();
        
        ClientService clientService = new ClientService(); 
        
        for (Client client : clientService.buscar()) {
            tabela.addRow(new Object[]{ 
                client.getIdCidade(), 
                client.getDescricaoCidade(),
                client.getUfCidade() 
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusCidade.getjButtonCarregar()){
         ControllerCadCidade.codigo = (int)this.telaBusCidade.getjTable1().getValueAt(this.telaBusCidade.getjTable1().getSelectedRow(), 0);
         this.telaBusCidade.dispose();
        }else if(e.getSource() == this.telaBusCidade.getjButtonSair()){
            this.telaBusCidade.dispose();
        }
    }
}