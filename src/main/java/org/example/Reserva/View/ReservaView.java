package org.example.Reserva.View;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Reserva.Model.Entity.Reserva;
import org.example.Sala.Model.Entity.Sala;

import java.util.Scanner;

public class ReservaView {
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
