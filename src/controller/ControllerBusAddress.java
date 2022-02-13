package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Endereco;
import service.AddressService;
import view.TelaBusAddress;

public class ControllerBusAddress implements ActionListener{
    
    TelaBusAddress screen;

    public ControllerBusAddress(TelaBusAddress screen) {
        
        this.screen = screen;
        
        screen.getjButtonCarregar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.screen.getjTable1().getModel();
        
        AddressService service = new AddressService();   
        
        for (Endereco endereco : service.buscar()) {
            tabela.addRow(new Object[]{ 
                endereco.getIdCep(),
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getLogradouroCep()
            });
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.screen.getjButtonCarregar()){
         ControllerCadCidade.codigo = 
         (int)this.screen.getjTable1().getValueAt(this.screen.getjTable1().getSelectedRow(), 0);
         this.screen.dispose();
        }else if(e.getSource() == this.screen.getjButtonSair()){
            this.screen.dispose();
        }
    }
}