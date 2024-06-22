package org.example.IntegracionDeSwing;
import org.example.Pelicula.Model.Entity.Pelicula;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionPeliculasView extends JFrame {

    private JPanel panelFondo;
    private ImageIcon imagenFondo;
public GestionPeliculasView() {
    setTitle("Reservas");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Cargar la imagen de fondo
    String rutaImagen = "src/main/resources/pelicula.jpg";
    imagenFondo = new ImageIcon(getClass().getClassLoader().getResource(rutaImagen));

    // Crear un JPanel personalizado para el fondo
    panelFondo = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar imagen de fondo
            g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    panelFondo.setLayout(new BorderLayout());

    /* Opcional: Configurar otros componentes sobre el fondo
    JLabel etiqueta = new JLabel("Contenido sobre el fondo");
    etiqueta.setForeground(Color.WHITE);
    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
    panelFondo.add(etiqueta, BorderLayout.CENTER);*/

    // Establecer panelFondo como el contenido del JFrame
    setContentPane(panelFondo);

    setLocationRelativeTo(null); // Centrar en pantalla
    setVisible(true);
}

public void verPelicula(Pelicula pelicula) {
    JOptionPane.showMessageDialog(this,
            "--------------------------\n" +
                    "Título: " + pelicula.getTitulo() + "\n" +
                    "Género: " + pelicula.getGenero() + "\n" +
                    "Duración: " + pelicula.getDuracion() + " minutos\n" +
                    "Fecha: " + pelicula.getFechasYhoras() + "\n" +
                    "--------------------------",
            "Detalles de la Película",
            JOptionPane.INFORMATION_MESSAGE);
}

public void mostrarListaPeliculas(JFrame parent, ArrayList<Pelicula> peliculas) {
    // Crear un nuevo JFrame para mostrar la lista de películas
    JFrame frame = new JFrame("Lista de Películas");
    frame.setSize(800, 400);
    frame.setLocationRelativeTo(parent);

    // Crear la tabla y su modelo
    DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Duración", "Fecha"}, 0);
    JTable tablePeliculas = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tablePeliculas);

    // Llenar la tabla con los datos de las películas
    for (Pelicula pelicula : peliculas) {
        tableModel.addRow(new Object[]{pelicula.getTitulo(), pelicula.getGenero(), pelicula.getDuracion(), pelicula.getFechasYhoras()});
    }

    // Añadir la tabla al JFrame
    frame.setLayout(new BorderLayout());
    frame.add(scrollPane, BorderLayout.CENTER);

    // Mostrar la ventana
    frame.setVisible(true);
}
}

