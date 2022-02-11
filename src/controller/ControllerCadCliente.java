package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bo.Client;
import service.ClientService;
import view.TelaBusCliente;
import view.TelaCadCliente;

public class ControllerCadCliente extends BaseController implements ActionListener {

    TelaCadCliente screen;
    public static int codigo;

    public ControllerCadCliente(TelaCadCliente screen) {
        this.screen = screen;

        screen.getjButtonBuscar().addActionListener(this);
        screen.getjButtonNovo().addActionListener(this);
        screen.getjButtonCancelar().addActionListener(this);
        screen.getjButtonGravar().addActionListener(this);
        screen.getjButtonSair().addActionListener(this);

        super.creationState(this.screen, false);
        super.enableFieldsForCreation(this.screen, false);
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCliente.getjButtonNovo()) {
            showButtons(false);
            ligaDesliga(true);
            this.telaCadCliente.getId().setEnabled(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonCancelar()) {
            showButtons(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonGravar()) {
            
            Client client = new Client();
            client.setNome(this.telaCadCliente.getFullName().getText());
                                    
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                client.setDtNasc(dateFormat.parse(this.telaCadCliente.getDateOfBirth().getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ControllerCadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            client.setRgCliente(this.telaCadCliente.getDocument_rg().getText());
            client.setCpfCliente(this.telaCadCliente.getDocument_cpf().getText());
            client.setFoneCliente(this.telaCadCliente.getTelephone_1().getText());
            client.setFone2Cliente(this.telaCadCliente.getTelephone_2().getText());
            client.setEmail(this.telaCadCliente.getEmail().getText());
            
            ClientService clientService = new ClientService();

            if (this.telaCadCliente.getId().getText().trim().equalsIgnoreCase("")) {
                clientService.salvar(client);
            } else {
                client.setIdCliente(Integer.parseInt(this.telaCadCliente.getId().getText()));
                clientService.atualizar(client);
            }
    
            showButtons(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonBuscar()) {
            codigo = 0;
            TelaBusCliente telaBusCliente = new TelaBusCliente(null, true);
            ControllerBusClient controllerBusClient = new ControllerBusClient(telaBusCliente);
            telaBusCliente.setVisible(true);

            if (codigo != 0) {
                Client client;
                ClientService clientService = new ClientService();
                client = clientService.buscar(codigo);

                showButtons(false);
                ligaDesliga(true);

                this.telaCadCliente.getjTFIdCidade().setText(cidade.getIdCidade() + "");
                this.telaCadCliente.getjTFNomeCidade().setText(cidade.getDescricaoCidade());
                this.telaCadCliente.getjTFUF().setText(cidade.getUfCidade());

                this.telaCadCliente.getjTFIdCidade().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadCliente.getjButtonSair()) {
            telaCadCliente.dispose();
        }
    }
}
