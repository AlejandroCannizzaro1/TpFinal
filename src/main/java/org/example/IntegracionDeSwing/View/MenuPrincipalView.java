package org.example.IntegracionDeSwing.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class MenuPrincipalView extends JFrame {

    private JButton btnGestionClientes;
    private JButton btnGestionPeliculas;
    private JButton btnGestionReservas;

    public MenuPrincipalView() {
        setTitle("Gestión de Cine");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana principal en la pantalla
        setLayout(new GridLayout(4, 1, 0, 20));
        // GridLayout para alinear verticalmente con espacio entre componentes

        btnGestionClientes = new JButton("Gestión de Clientes");
        add(btnGestionClientes);

        btnGestionPeliculas = new JButton("Gestión de Películas");
        add(btnGestionPeliculas);


        btnGestionReservas = new JButton("Gestión de Reservas");
        add(btnGestionReservas);

        centrarVentanaEnPantalla(this); // Método para centrar esta ventana

        setVisible(true); // Hacer visible la ventana principal
    }

    private void centrarVentanaEnPantalla(Window ventana) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - ventana.getWidth()) / 2;
        int centerY = (screenSize.height - ventana.getHeight()) / 2;
        ventana.setLocation(centerX, centerY);
    }

    public void addGestionClientesListener(ActionListener listenForGestionClientesButton) {
        btnGestionClientes.addActionListener(listenForGestionClientesButton);
    }

    public void addGestionPeliculasListener(ActionListener listenForGestionPeliculasButton) {
        btnGestionPeliculas.addActionListener(listenForGestionPeliculasButton);
    }



    public void addGestionReservasListener(ActionListener listenForGestionReservasButton) {
        btnGestionReservas.addActionListener(listenForGestionReservasButton);
    }
}
