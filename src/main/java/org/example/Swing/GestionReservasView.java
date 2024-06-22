package org.example.IntegracionDeSwing;

import org.example.Sala.Model.Entity.Butaca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
//      SwingUtilities.invokeLater(() -> new JFrameConFondo()); En el main va esto o donde se instancie esta
// clase
import org.example.Reserva.Model.Entity.Reserva;
public class GestionReservasView extends JFrame {
    private JPanel panelFondo;
    private ImageIcon imagenFondo;

    public GestionReservasView() {
        setTitle("Reservas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar la imagen de fondo
        String rutaImagen = "src/main/resources/fondo.jpg";
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


    public void verReserva(Reserva reserva, JFrame parent) {


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Hacer el JTextArea no editable

        textArea.append("Detalles de la Reserva:\n");
        textArea.append("Cliente: " + reserva.getCliente().getNombreYapellido() + "\n");
        textArea.append("DNI Cliente: " + reserva.getCliente().getDni() + "\n");
        textArea.append("Edad Cliente: " + reserva.getCliente().getEdad() + "\n\n");

        textArea.append("Película:\n");
        textArea.append("Título: " + reserva.getPelicula().getTitulo() + "\n");
        textArea.append("Género: " + reserva.getPelicula().getGenero() + "\n");
        textArea.append("Duración: " + reserva.getPelicula().getDuracion() + " minutos\n");
        textArea.append("Fecha: " + reserva.getPelicula().getFechasYhoras() + "\n\n");


       /* textArea.append("Sala:\n");
        textArea.append("Número de Sala: " + reserva.getSala().getNumeroSala() + "\n");
        textArea.append("Butacas Disponibles: \n");

        for (Butaca butaca : reserva.getSala().getButacas()) {
            if (butaca.getDisponibilidad().equals("DISPONIBLE")) {
                textArea.append("[" + butaca.getNumero() + "] ");
            }
        }*/



        textArea.append("\n\n");

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JOptionPane.showMessageDialog(parent, scrollPane, "Detalles de la Reserva", JOptionPane.PLAIN_MESSAGE);
    }

    public void verReservas(Map<Integer, Reserva> reservasMap, JFrame parent) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Hacer el JTextArea no editable

        for (Map.Entry<Integer, Reserva> entry : reservasMap.entrySet()) {
            Reserva reserva = entry.getValue();

            textArea.append("Detalles de la Reserva:\n");
            textArea.append("Cliente: " + reserva.getCliente().getNombreYapellido() + "\n");
            textArea.append("DNI Cliente: " + reserva.getCliente().getDni() + "\n");
            textArea.append("Edad Cliente: " + reserva.getCliente().getEdad() + "\n\n");

            textArea.append("Película:\n");
            textArea.append("Título: " + reserva.getPelicula().getTitulo() + "\n");
            textArea.append("Género: " + reserva.getPelicula().getGenero() + "\n");
            textArea.append("Duración: " + reserva.getPelicula().getDuracion() + " minutos\n");
            textArea.append("Fecha: " + reserva.getPelicula().getFechasYhoras() + "\n\n");
/*
            textArea.append("Sala:\n");
            textArea.append("Número de Sala: " + reserva.getSala().getNumeroSala() + "\n");
            textArea.append("Butacas Disponibles: \n");

            for (Butaca butaca : reserva.getSala().getButacas()) {
                if (butaca.getDisponibilidad().equals("DISPONIBLE")) {
                    textArea.append("[" + butaca.getNumero() + "] ");
                }
            }*/

            textArea.append("\n\n");
            textArea.append("--------------------------\n\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JOptionPane.showMessageDialog(parent, scrollPane, "Lista de Reservas", JOptionPane.PLAIN_MESSAGE);
    }

}