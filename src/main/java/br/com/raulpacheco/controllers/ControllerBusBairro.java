package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Bairro;
import br.com.raulpacheco.services.BairroService;
import br.com.raulpacheco.views.TelaBusBairro;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusBairro implements ActionListener {

    TelaBusBairro telaBusBairro;

    public ControllerBusBairro(TelaBusBairro telaBusBairro) {

        this.telaBusBairro = telaBusBairro;

        telaBusBairro.getjButtonCarregar().addActionListener(this);
        telaBusBairro.getjButtonSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.telaBusBairro.getjTable1().getModel();

        BairroService bairroService = new BairroService();

        for (Bairro bairro : bairroService.search()) {
            tabela.addRow(new Object[]{
                    bairro.getIdBairro(),
                    bairro.getDescricaoBairro()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBusBairro.getjButtonCarregar()) {
            ControllerCadBairro.codigo =
                    (int) this.telaBusBairro.getjTable1().getValueAt(this.telaBusBairro.getjTable1().getSelectedRow(), 0);
            this.telaBusBairro.dispose();
        } else if (e.getSource() == this.telaBusBairro.getjButtonSair()) {
            this.telaBusBairro.dispose();
        }
    }
}