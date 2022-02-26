package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Endereco;
import service.AddressService;
import view.TelaBusAddress;

public class ControllerBusAddress implements ActionListener{
    
    TelaBusAddress telaBusBairro;
    AddressService addressService = new AddressService();

    public ControllerBusAddress(TelaBusAddress telaBusBairro) {

        this.telaBusBairro = telaBusBairro;
        
        telaBusBairro.getjButtonCarregar().addActionListener(this);
        telaBusBairro.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusBairro.getjTable1().getModel();
        
        for (Endereco bairro : this.addressService.buscar()) {
            tabela.addRow(new Object[]{ 
                bairro.getIdCep(),
                bairro.getCidade()
//                bairro.getLogradouroCep()
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusBairro.getjButtonCarregar()){
         ControllerCadBairro.codigo = 
         (int)this.telaBusBairro.getjTable1().getValueAt(this.telaBusBairro.getjTable1().getSelectedRow(), 0);
         this.telaBusBairro.dispose();
        }else if(e.getSource() == this.telaBusBairro.getjButtonSair()){
            this.telaBusBairro.dispose();
        }
    }
}