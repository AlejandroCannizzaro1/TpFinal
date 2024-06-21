package org.example.Reserva.View;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Reserva.Model.Entity.Reserva;
import org.example.Sala.Model.Entity.Sala;

import javax.swing.*;
import java.util.Scanner;

public class ReservaView {
    public Reserva crearReserva(Cliente cliente, Pelicula pelicula, Sala sala, JFrame parent) {
        int id = Integer.parseInt(JOptionPane.showInputDialog(parent, "Ingrese el ID de la reserva:"));
        return new Reserva(id, cliente, pelicula, sala);
    }

    public void verReserva(Reserva reserva, JFrame parent) {
        JTextArea textArea = new JTextArea();
        textArea.append("Detalles de la Reserva:\n");
        textArea.append("Cliente: " + reserva.getCliente().getNombreYapellido() + "\n");
        textArea.append("Sala: " + reserva.getSala().getNumeroSala() + "\n");
        textArea.append("Butacas: " + reserva.getSala().getButacas() + "\n");

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JOptionPane.showMessageDialog(parent, scrollPane, "Detalles de la Reserva", JOptionPane.PLAIN_MESSAGE);
    }

}
    /*
    Scanner scanner = new Scanner(System.in);

    public Reserva crearReserva(Cliente cliente, Pelicula pelicula, Sala sala){
        System.out.println("ID de la reserva: ");
        int id = scanner.nextInt();
        return new Reserva(id, cliente, pelicula, sala);
    }

    public void verReserva(Reserva reserva) {
        System.out.println(reserva.getCliente().getNombreYapellido() + " - Sala: " + reserva.getSala().getNumeroSala() + " - Butacas: " + reserva.getSala().getButacas());
    }
}
*/