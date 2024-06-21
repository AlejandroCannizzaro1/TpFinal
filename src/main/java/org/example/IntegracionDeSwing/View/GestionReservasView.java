package org.example.IntegracionDeSwing.View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GestionReservasView extends JFrame {
    private JTable tableReservas;
    private JButton btnAgregarReserva;
    private JButton btnEliminarReserva;

    public GestionReservasView() {
        setTitle("Gestión de Reservas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        tableReservas = new JTable(); // Configurar con un TableModel apropiado
        JScrollPane scrollPane = new JScrollPane(tableReservas);
        scrollPane.setBounds(20, 20, 540, 250);
        add(scrollPane);

        btnAgregarReserva = new JButton("Agregar Reserva");
        btnAgregarReserva.setBounds(20, 300, 150, 30);
        add(btnAgregarReserva);

        btnEliminarReserva = new JButton("Eliminar Reserva");
        btnEliminarReserva.setBounds(200, 300, 150, 30);
        add(btnEliminarReserva);
    }

    public void addAgregarReservaListener(ActionListener listenForAgregarReservaButton) {
        btnAgregarReserva.addActionListener(listenForAgregarReservaButton);
    }

    public void addEliminarReservaListener(ActionListener listenForEliminarReservaButton) {
        btnEliminarReserva.addActionListener(listenForEliminarReservaButton);
    }
}