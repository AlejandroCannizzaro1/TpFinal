package org.example.Reserva.Controller;

import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Entity.Cliente;
import org.example.Excepciones.Excepciones;
import org.example.Excepciones.Validar;
import org.example.Pelicula.Controller.PeliculaController;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Reserva.Model.Entity.Reserva;
import org.example.Reserva.Model.Repository.ReservaRepository;
import org.example.Reserva.View.ReservaView;
import org.example.Sala.Controller.SalaController;
import org.example.Sala.Model.Entity.Sala;

import java.util.Date;
import java.util.Scanner;

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

    public void generarReserva(){
        String dni = clienteController.getClienteView().validarDni(); // busco cliente x dni
        Cliente clienteEncontrado = null;
        boolean ok = false;

        for (Cliente cliente : clienteController.getClienteRepository().getListaClientes()){
            if(cliente.getDni().equals(dni)){
                clienteEncontrado = cliente;
                clienteController.getClienteView().mostrarCliente(clienteEncontrado); // si lo encuentra lo muestra y lo guarda
                ok = true;
            }
        }
        if(!ok){ // si no lo encuentra lo crea y lo muestra
            String nombre = clienteController.getClienteView().validarNombreYapellido();
            int edad = clienteController.getClienteView().validarEdad();
            clienteEncontrado = new Cliente(dni, nombre, edad);
            clienteController.getClienteRepository().registrar(clienteEncontrado);
            clienteController.getClienteView().mostrarCliente(clienteEncontrado);
        }

        Date fechaHoy = new Date();
        peliculaController.mostrarPelisFuturo(fechaHoy);
        System.out.print("Ingrese el titulo: ");

        Pelicula peliEncontrada = peliculaController.getPeliculaRepository().consultar(scanner.nextLine()); // devuelve la peli buscada x titulo // no olvidarse de validar (HACER)
        getPeliculaController().getPeliculaView().verPelicula(peliEncontrada); // muestro la peli elegida


        Sala sala = new Sala(2);
        salaController.getSalaRepository().addSala(sala); // guardo en el repo la sala recien creada

        salaController.elegirButacas(sala.getNumeroSala()); // le paso la numero 2 porque lo hardcodie arriba // se eligen las butacas

        Reserva reservaNueva = reservaView.crearReserva(clienteEncontrado, peliEncontrada, sala); // instancio la reserva nueva con los datos

        reservaRepository.agregarReserva(reservaNueva.getId(), reservaNueva); // guardo la reserva en el repo
    }
}
