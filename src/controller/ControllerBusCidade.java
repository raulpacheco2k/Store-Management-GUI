package controller;

import model.bo.Cidade;
import service.CidadeService;
import view.TelaBusCidade;

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

        for (Cidade cidadeAtualDaLista : cidadeService.buscar()) {
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
            ControllerCadCidade.codigo =
                    (int) this.telaBusCidade.getjTable1().getValueAt(this.telaBusCidade.getjTable1().getSelectedRow(), 0);
            this.telaBusCidade.dispose();
        } else if (e.getSource() == this.telaBusCidade.getjButtonSair()) {
            this.telaBusCidade.dispose();
        }
    }
}