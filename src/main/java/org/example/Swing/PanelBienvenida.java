package org.example.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBienvenida extends JFrame {

    public PanelBienvenida() {
        // Configuración del JFrame
        setTitle("Cine App - Bienvenida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Crear el panel de bienvenida
        JPanel bienvenidaPanel = new JPanel(new BorderLayout());
        bienvenidaPanel.setBackground(new Color(60, 63, 65));

        JLabel label = new JLabel("Bienvenido al Cine Trivium ACG", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        bienvenidaPanel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(60, 63, 65));
        JButton continueButton = new JButton("Continuar");
        continueButton.setFont(new Font("Serif", Font.BOLD, 16));
        continueButton.setBackground(new Color(28, 28, 28));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar el panel de bienvenida
                // Aquí puedes continuar con el resto de la lógica de la aplicación
            }
        });
        buttonPanel.add(continueButton);
        bienvenidaPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar el panel de bienvenida al frame
        getContentPane().add(bienvenidaPanel);
    }

    public void mostrar() {
        setVisible(true);
    }

}
