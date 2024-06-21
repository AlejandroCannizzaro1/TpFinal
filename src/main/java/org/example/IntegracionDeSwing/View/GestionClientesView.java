package org.example.IntegracionDeSwing.View;
import javax.swing.*;
import java.awt.event.ActionListener;

public class GestionClientesView extends JFrame {
    private JTable tableClientes;
    private JButton btnAgregarCliente;
    private JButton btnEliminarCliente;

    public GestionClientesView() {
        setTitle("Gestión de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        tableClientes = new JTable(); // Configurar con un TableModel apropiado
        JScrollPane scrollPane = new JScrollPane(tableClientes);
        scrollPane.setBounds(20, 20, 540, 250);
        add(scrollPane);

        btnAgregarCliente = new JButton("Agregar Cliente");
        btnAgregarCliente.setBounds(20, 300, 150, 30);
        add(btnAgregarCliente);

        btnEliminarCliente = new JButton("Eliminar Cliente");
        btnEliminarCliente.setBounds(200, 300, 150, 30);
        add(btnEliminarCliente);
    }

    public void addAgregarClienteListener(ActionListener listenForAgregarClienteButton) {
        btnAgregarCliente.addActionListener(listenForAgregarClienteButton);
    }

    public void addEliminarClienteListener(ActionListener listenForEliminarClienteButton) {
        btnEliminarCliente.addActionListener(listenForEliminarClienteButton);
    }
}