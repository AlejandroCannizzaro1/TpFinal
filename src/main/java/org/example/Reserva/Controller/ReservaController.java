package org.example.Reserva.Controller;

import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Entity.Cliente;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.Pelicula.Controller.PeliculaController;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Reserva.Model.Entity.Reserva;
import org.example.Reserva.Model.Repository.ReservaRepository;
import org.example.Reserva.View.ReservaView;
import org.example.Sala.Controller.SalaController;
import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;
import org.example.Swing.GestionClientesView;
import org.example.Swing.GestionPeliculasView;
import org.example.Swing.GestionReservasView;
import org.example.Validaciones.Validar;

import javax.swing.*;
import java.util.*;

public class ReservaController {
    private ReservaView reservaView;
    private ClienteView clienteView;
    private ReservaRepository reservaRepository;
    private ClienteRepository clienteRepository;
    private ClienteController clienteController;
    private PeliculaController peliculaController;
    private SalaController salaController;
    GestionReservasView gestionReservasView;
   GestionPeliculasView gestionPeliculasView;
   GestionClientesView gestionClientesView;

    Scanner scanner = new Scanner(System.in);
    Validar validar = new Validar();

    public ReservaController(ReservaView reservaView, ReservaRepository reservaRepository, ClienteController clienteController,
                             PeliculaController peliculaController, SalaController salaController,
                             GestionClientesView gestionClientesView, GestionPeliculasView gestionPeliculasView,
                             GestionReservasView gestionReservasView, ClienteView clienteView, ClienteRepository clienteRepository) {
        this.reservaView = reservaView;
        this.reservaRepository = reservaRepository;
        this.clienteController = clienteController;
        this.peliculaController = peliculaController;
        this.salaController = salaController;
        this.gestionPeliculasView = gestionPeliculasView;
        this.gestionClientesView = gestionClientesView;
        this.gestionReservasView = gestionReservasView;
        this.clienteView = clienteView;
        this.clienteRepository = clienteRepository;

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
    public void mostrarListReservas(){
        Map <Integer, Reserva> mapReservas = this.reservaRepository.getReservaMap();
        if(!mapReservas.isEmpty()){
            this.gestionReservasView.verReservas(mapReservas, this.gestionReservasView);
        } else {
            JOptionPane.showMessageDialog(null, "Mapa vacio" , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void generarReserva() {
        String dni = clienteController.getClienteView().validarDni(gestionClientesView); // busco cliente x dni
        Cliente clienteEncontrado = null;
        boolean ok = false;

        for (Cliente cliente : clienteController.getClienteRepository().getListaClientes()) {
            if (cliente.getDni().equals(dni)) {
                clienteEncontrado = cliente;
                gestionClientesView.mostrarCliente(gestionClientesView, clienteEncontrado); // si lo encuentra lo muestra y lo guarda
                ok = true;
            }
        }
        if (!ok) { // si no lo encuentra lo crea y lo muestra
            String nombre = clienteController.getClienteView().validarNombreYapellido(gestionClientesView);
            int edad = clienteController.getClienteView().validarEdad(gestionClientesView);
            clienteEncontrado = new Cliente(dni, nombre, edad);
            clienteController.getClienteRepository().registrar(clienteEncontrado);
            gestionClientesView.mostrarCliente(gestionClientesView, clienteEncontrado);
        }

        Date fechaHoy = new Date();
        peliculaController.mostrarPelisFuturo(fechaHoy);

        Pelicula peliEncontrada = peliculaController.getPeliculaRepository().consultar(peliculaController.getPeliculaRepository().validarPelicula()); // devuelve la peli buscada x titulo //
        gestionPeliculasView.verPelicula(gestionPeliculasView, peliEncontrada); // muestro la peli elegida

        Sala salaDisponible;
        boolean listo = false;
        boolean ok2 = false;

        for (Map.Entry<Integer, Reserva> entry : reservaRepository.getReservaMap().entrySet()) {
            if (entry.getValue().getPelicula().getTitulo().equals(peliEncontrada.getTitulo())) { // se fija si hay una reserva para esa peli
                for (Butaca butaca : peliEncontrada.getSala().getButacas()) {
                    if(butaca.getDisponibilidad().equals("DISPONIBLE")){
                        ok2 = true;
                    }
                }
                if (ok2){
                    generarReserva(peliEncontrada, clienteEncontrado);
                    listo = true;
                }
            }
        }
        int flag = 0;
        if(!listo) {
            do {
                salaDisponible = salaController.getSalaRepository().consultar(scanner.nextInt());
                if (salaDisponible != null){
                    flag = 1;
                    JOptionPane.showMessageDialog(null, "Sala " + salaDisponible.getNumeroSala() + " disponible ", "Reservas", JOptionPane.INFORMATION_MESSAGE);
                    peliEncontrada.setSala(salaDisponible);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Sala No Disponible", "Reservas", JOptionPane.ERROR_MESSAGE);
                }
            }while(flag == 0);
            generarReserva(peliEncontrada, clienteEncontrado);
        }
    }

    public void generarReserva(Pelicula peliEncontrada, Cliente clienteEncontrado) {
       int numeroSala = peliEncontrada.getSala().getNumeroSala();
        JOptionPane.showMessageDialog(null, "Numero de sala " + numeroSala , "Reservas", JOptionPane.INFORMATION_MESSAGE);
        salaController.elegirButacas(clienteEncontrado, peliEncontrada.getSala());

        Reserva reservaNueva = reservaRepository.crearReserva(clienteEncontrado, peliEncontrada); // instancio la reserva nueva con los datos

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
            JOptionPane.showMessageDialog(null, "No hay reservas registradas", "Reservas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Map.Entry<Integer, Reserva> entry : reservaRepository.getReservaMap().entrySet()) {
                gestionReservasView.verReserva(entry.getValue(), gestionReservasView);
            }
        }
    }

    public void buscarPorCliente() {
        String id = this.clienteView.pedirDniCliente(gestionClientesView);
        Cliente cliente = this.clienteRepository.consultar(id);
        if (cliente != null) {
        if(!this.reservaRepository.getReservaMap().isEmpty()) {
                for (Map.Entry<Integer, Reserva> entry : reservaRepository.getReservaMap().entrySet()) {
                    Reserva reserva = entry.getValue();
                    if (reserva.getCliente().getDni().equals(cliente.getDni())) {
                        gestionReservasView.verReserva(entry.getValue(), gestionReservasView);
                    }
                }
        } else {
            JOptionPane.showMessageDialog(null, "No hay reservas registradas", "Reservas", JOptionPane.INFORMATION_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente == null", "Clientes", JOptionPane.ERROR_MESSAGE);
        }
    }
}
