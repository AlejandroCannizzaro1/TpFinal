package org.example.Reserva.Controller;

import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Entity.Cliente;
import org.example.Pelicula.Controller.PeliculaController;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Reserva.Model.Entity.Reserva;
import org.example.Reserva.Model.Repository.ReservaRepository;
import org.example.Reserva.View.ReservaView;
import org.example.Sala.Controller.SalaController;
import org.example.Sala.Model.Entity.Sala;
import org.example.Validaciones.Validar;

import java.util.*;

public class ReservaController {
    private ReservaView reservaView;
    private ReservaRepository reservaRepository;
    private ClienteController clienteController;
    private PeliculaController peliculaController;
    private SalaController salaController;

    Scanner scanner = new Scanner(System.in);
    Validar validar = new Validar();

    public ReservaController(ReservaView reservaView, ReservaRepository reservaRepository, ClienteController clienteController, PeliculaController peliculaController, SalaController salaController) {
        this.reservaView = reservaView;
        this.reservaRepository = reservaRepository;
        this.clienteController = clienteController;
        this.peliculaController = peliculaController;
        this.salaController = salaController;
    }

    public ReservaView getReservaView() {
        return reservaView;
    }

    public void setReservaView(ReservaView reservaView) {
        this.reservaView = reservaView;
    }

    public ReservaRepository getReservaRepository() {
        return reservaRepository;
    }

    public void setReservaRepository(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public ClienteController getClienteController() {
        return clienteController;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public PeliculaController getPeliculaController() {
        return peliculaController;
    }

    public void setPeliculaController(PeliculaController peliculaController) {
        this.peliculaController = peliculaController;
    }

    public void generarReserva() {
        String dni = clienteController.getClienteView().validarDni(); // busco cliente x dni
        Cliente clienteEncontrado = null;
        boolean ok = false;

        for (Cliente cliente : clienteController.getClienteRepository().getListaClientes()) {
            if (cliente.getDni().equals(dni)) {
                clienteEncontrado = cliente;
                clienteController.getClienteView().mostrarCliente(clienteEncontrado); // si lo encuentra lo muestra y lo guarda
                ok = true;
            }
        }
        if (!ok) { // si no lo encuentra lo crea y lo muestra
            String nombre = clienteController.getClienteView().validarNombreYapellido();
            int edad = clienteController.getClienteView().validarEdad();
            clienteEncontrado = new Cliente(dni, nombre, edad);
            clienteController.getClienteRepository().registrar(clienteEncontrado);
            clienteController.getClienteView().mostrarCliente(clienteEncontrado);
        }

        Date fechaHoy = new Date();
        peliculaController.mostrarPelisFuturo(fechaHoy);

        Pelicula peliEncontrada = peliculaController.getPeliculaRepository().consultar(peliculaController.getPeliculaRepository().validarPelicula()); // devuelve la peli buscada x titulo //
        getPeliculaController().getPeliculaView().verPelicula(peliEncontrada); // muestro la peli elegida

        Sala salaDisponible;
        boolean listo = false;

        for (Map.Entry<Integer, Reserva> entry : reservaRepository.getReservaMap().entrySet()) {
            if (entry.getValue().getPelicula().getTitulo().equals(peliEncontrada.getTitulo())) { // se fija si hay una reserva para esa peli
                generarReserva(peliEncontrada, clienteEncontrado);
                listo = true;
            }
        }
        int flag = 0;
        if(!listo) {
            do {
                System.out.print("Sala: ");
                salaDisponible = salaController.getSalaRepository().consultar(scanner.nextInt());
                if (salaDisponible != null){
                    flag = 1;
                    peliEncontrada.setSala(salaDisponible);
                }
                else {
                    System.out.print("Esa no es una sala valida...");
                }
            }while(flag == 0);
            generarReserva(peliEncontrada, clienteEncontrado);
        }
    }

    public void generarReserva(Pelicula peliEncontrada, Cliente clienteEncontrado) {
        System.out.println("Numero de sala: " + peliEncontrada.getSala().getNumeroSala());
        salaController.elegirButacas(clienteEncontrado, peliEncontrada.getSala());

        Reserva reservaNueva = reservaView.crearReserva(clienteEncontrado, peliEncontrada); // instancio la reserva nueva con los datos

        reservaRepository.agregarReserva(reservaNueva.getId(), reservaNueva); // guardo la reserva en el repo

        peliculaController.getPeliculaRepository().savePeliculas();
    }

    public void loadSalas() {
        for (Map.Entry<Integer, Reserva> entryMap : reservaRepository.getReservaMap().entrySet()) {
            for (Object pelicula : peliculaController.getPeliculaRepository().getListaPeliculas()) {
                Pelicula pelicula1 = (Pelicula) pelicula;
                if (Objects.equals(pelicula1.getTitulo(), entryMap.getValue().getPelicula().getTitulo())) {
                    pelicula1.setSala(entryMap.getValue().getPelicula().getSala());
                }
            }
        }
    }

    public void mostrarReservas() {
        if (reservaRepository.getReservaMap().isEmpty()) {
            System.out.println("No hay reservas registradas...");
        } else {
            for (Map.Entry<Integer, Reserva> entry : reservaRepository.getReservaMap().entrySet()) {
                reservaView.verReserva(entry.getValue());
            }
        }
    }

    public void buscarPorCliente(Cliente cliente) {
        for (Map.Entry<Integer, Reserva> entry : reservaRepository.getReservaMap().entrySet()) {
            if(entry.getValue().getCliente().getDni().equals(cliente.getDni())) {
                reservaView.verReserva(entry.getValue());
            }
        }
    }
}
