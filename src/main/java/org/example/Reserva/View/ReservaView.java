package org.example.Reserva.View;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Reserva.Model.Entity.Reserva;
import org.example.Sala.Model.Entity.Butaca;

import java.util.Objects;
import java.util.Scanner;


public class ReservaView {

    Scanner scanner = new Scanner(System.in);

    public Reserva crearReserva(Cliente cliente, Pelicula pelicula) {
        System.out.print("ID de la reserva: ");
        int id = scanner.nextInt();
        System.out.println(id);
        return new Reserva(id, cliente, pelicula);
    }

    public void verReserva(Reserva reserva) { // corregir

        System.out.print(reserva.getCliente().getNombreYapellido() + " - Sala " + reserva.getPelicula().getSala().getNumeroSala() + " - " + reserva.getPelicula().getTitulo() + " - " + reserva.getPelicula().getFechasYhoras() + "- Butacas: ");
        for (Butaca butaca : reserva.getPelicula().getSala().getButacas()) {
            Cliente butacaCliente = butaca.getCliente();
            if ((butacaCliente != null) && (Objects.equals(butacaCliente.getDni(), reserva.getCliente().getDni()))) {
                System.out.print("[" + butaca.getNumero() + "]");
            }
        }
        System.out.println("\n");
    }
}
