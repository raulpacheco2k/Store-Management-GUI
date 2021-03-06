package br.com.raulpacheco.controllers;

import br.com.raulpacheco.models.bo.Cidade;
import br.com.raulpacheco.services.CidadeService;;
import br.com.raulpacheco.views.TelaBusCidade;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusCidade implements ActionListener {

    TelaBusCidade telaBusCidade;

    public ControllerBusCidade(TelaBusCidade telaBusCidade) {

        this.telaBusCidade = telaBusCidade;

        telaBusCidade.getjButtonCarregar().addActionListener(this);
        telaBusCidade.getjButtonSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCidade.getjTable1().getModel();

        CidadeService cidadeService = new CidadeService();

        for (Cidade cidadeAtualDaLista : cidadeService.search()) {
            tabela.addRow(new Object[]{
                    cidadeAtualDaLista.getIdCidade(),
                    cidadeAtualDaLista.getDescricaoCidade(),
                    cidadeAtualDaLista.getUfCidade()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBusCidade.getjButtonCarregar()) {
            ControllerCadCidade.id =
                    (int) this.telaBusCidade.getjTable1().getValueAt(this.telaBusCidade.getjTable1().getSelectedRow(), 0);
            this.telaBusCidade.dispose();
        } else if (e.getSource() == this.telaBusCidade.getjButtonSair()) {
            this.telaBusCidade.dispose();
        }
    }
}