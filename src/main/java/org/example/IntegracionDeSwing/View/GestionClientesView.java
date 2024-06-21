package org.example.IntegracionDeSwing.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class GestionClientesView extends JFrame {
    private JTable tableClientes;
    private JButton btnAgregarCliente;
    private JButton btnEliminarCliente;
    private JButton btnActualizarCliente;
    private JButton btnConsultarCliente;
    private DefaultTableModel tableModel;

    public GestionClientesView() {
        setTitle("Gestión de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Dni", "Edad"}, 0);
        tableClientes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableClientes);
        scrollPane.setBounds(20, 20, 540, 250);
        add(scrollPane);


        btnAgregarCliente = new JButton("Agregar Cliente");
        btnAgregarCliente.setBounds(20, 300, 150, 30);
        add(btnAgregarCliente);


        btnEliminarCliente = new JButton("Eliminar Cliente");
        btnEliminarCliente.setBounds(200, 300, 150, 30);
        add(btnEliminarCliente);

        btnActualizarCliente = new JButton("Actualizar Cliente");
        btnActualizarCliente.setBounds(380, 300, 150, 30);
        add(btnActualizarCliente);

        btnConsultarCliente = new JButton("Consultar Cliente");
        btnConsultarCliente.setBounds(560, 300, 150, 30);
        add(btnConsultarCliente);
    }

    public void addAgregarClienteListener(ActionListener listenForAgregarClienteButton) {
        btnAgregarCliente.addActionListener(listenForAgregarClienteButton);
    }


    public void addEliminarClienteListener(ActionListener listenForEliminarClienteButton) {
        btnEliminarCliente.addActionListener(listenForEliminarClienteButton);
    }
    public void addActualizarClienteListener(ActionListener listener) {
        btnActualizarCliente.addActionListener(listener);
    }

    public void addConsultarClienteListener(ActionListener listener) {
        btnConsultarCliente.addActionListener(listener);
    }
}