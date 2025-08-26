package br.com.raulpacheco.controllers;

import br.com.raulpacheco.views.BaseMenuButtonsInterface;

import javax.swing.*;
import java.awt.*;

public class BaseController {

    public void cancel(BaseMenuButtonsInterface screen) {
        creationState(screen, false);
        enableFieldsForCreation(screen, false);
    }

    public void creationState(BaseMenuButtonsInterface screen, boolean estado) {
        screen.getjButtonNovo().setEnabled(!estado);
        screen.getjButtonCancelar().setEnabled(estado);
        screen.getjButtonGravar().setEnabled(estado);
        screen.getjButtonBuscar().setEnabled(!estado);
        screen.getjButtonSair().setEnabled(!estado);
    }

    public void enableFieldsForCreation(BaseMenuButtonsInterface screen, boolean estado) {
        processComponents(screen.getjPanelDados(), estado);
    }

    private void processComponents(Container container, boolean estado) {
        for (Component componenteAtual : container.getComponents()) {
            if (componenteAtual instanceof JTextField) {
                ((JTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JComboBox) {
                ((JComboBox<?>) componenteAtual).setSelectedIndex(0);
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JButton) {
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof Container) {
                // Recursively handle nested panels/containers
                processComponents((Container) componenteAtual, estado);
            }
        }
    }
}
