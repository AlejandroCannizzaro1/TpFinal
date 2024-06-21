package org.example.IntegracionDeSwing.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class GestionReservasView extends JFrame {
    private JTable tableReservas;
    private JButton btnAgregarReserva;
    private JButton btnEliminarReserva;
    private JButton btnConsultarReserva;
    private DefaultTableModel tableModel;

    public GestionReservasView() {
        setTitle("Gestión de Reservas");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

         tableModel = new DefaultTableModel(new Object[]{"Cliente", "Pelicula", "Reserva"}, 0);
        tableReservas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableReservas);
        scrollPane.setBounds(20, 20, 540, 250);
        add(scrollPane);

        btnAgregarReserva = new JButton("Agregar Reserva");
        btnAgregarReserva.setBounds(20, 300, 150, 30);
        add(btnAgregarReserva);

        btnEliminarReserva = new JButton("Eliminar Reserva");
        btnEliminarReserva.setBounds(200, 300, 150, 30);
        add(btnEliminarReserva);

        btnConsultarReserva = new JButton("Consultar  Reserva");
        btnConsultarReserva.setBounds(380, 300, 150, 30);
        add(btnConsultarReserva);
    }

    public void addAgregarReservaListener(ActionListener listenForAgregarReservaButton) {
        btnAgregarReserva.addActionListener(listenForAgregarReservaButton);
    }

    public void addEliminarReservaListener(ActionListener listenForEliminarReservaButton) {
        btnEliminarReserva.addActionListener(listenForEliminarReservaButton);
    }


    public void addConsultarReservaListener(ActionListener listener) {
        btnConsultarReserva.addActionListener(listener);
    }
}