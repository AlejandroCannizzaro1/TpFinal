package org.example.IntegracionDeSwing.View;
import org.example.Pelicula.Model.Entity.Pelicula;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionPeliculasView extends JFrame{
    private JTable tablePeliculas;
    private JButton btnAgregarPelicula;
    private JButton btnEliminarPelicula;
    private JButton btnActualizarPelicula;
    private JButton btnConsultarPelicula;
    private DefaultTableModel tableModel;

    public GestionPeliculasView() {
        setTitle("Gestion de Películas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

       tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Duración", "Fecha"}, 0);
        tablePeliculas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tablePeliculas);
        scrollPane.setBounds(20, 20, 540, 250);
        add(scrollPane);

        btnAgregarPelicula = new JButton("Agregar Película");
        btnAgregarPelicula.setBounds(20, 300, 150, 30);
        add(btnAgregarPelicula);

        btnEliminarPelicula = new JButton("Eliminar Película");
        btnEliminarPelicula.setBounds(200, 300, 150, 30);
        add(btnEliminarPelicula);

        btnActualizarPelicula = new JButton("Actualizar Pelicula");
        btnActualizarPelicula.setBounds(400, 300, 150, 30);
        add(btnActualizarPelicula);

        btnConsultarPelicula = new JButton("Consultar Pelicula");
        btnConsultarPelicula.setBounds(600, 300, 150, 30);
        add(btnConsultarPelicula);
    }

    public void addAgregarPeliculaListener(ActionListener listener) {
        btnAgregarPelicula.addActionListener(listener);

    }

    public void addEliminarPeliculaListener(ActionListener listener) {
        btnEliminarPelicula.addActionListener(listener);
    }

    public void addActualizarPeliculaListener(ActionListener listener) {
        btnActualizarPelicula.addActionListener(listener);
    }

    public void addConsultarPeliculaListener(ActionListener listener) {
        btnConsultarPelicula.addActionListener(listener);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public int getSelectedRow() {
        return tablePeliculas.getSelectedRow();
    }
    public void refreshPeliculasTable(ArrayList<Pelicula> peliculas) {
        tableModel.setRowCount(0); // Limpiar la tabla antes de actualizar
        for (Pelicula pelicula : peliculas) {
            tableModel.addRow(new Object[]{pelicula.getTitulo(), pelicula.getGenero(), pelicula.getDuracion(), pelicula.getFechasYhoras().toString()});
        }
    }
}
