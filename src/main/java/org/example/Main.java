package org.example;


import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Entity.Cliente;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.IntegracionDeSwing.View.MenuPrincipalView;
import org.example.IntegracionDeSwing.View.MenuPrincipalViewController;
import org.example.Pelicula.Controller.PeliculaController;
import org.example.Pelicula.Model.Repository.PeliculaRepository;
import org.example.Pelicula.View.PeliculaView;
import org.example.Reserva.Controller.ReservaController;
import org.example.Reserva.Model.Repository.ReservaRepository;
import org.example.Reserva.View.ReservaView;
import org.example.Sala.Controller.SalaController;
import org.example.Sala.Model.Repository.SalaRepository;
import org.example.Sala.View.SalaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(clienteRepository, clienteView);

        PeliculaView peliculaView = new PeliculaView();
        PeliculaRepository peliculaRepository = new PeliculaRepository();
        PeliculaController peliculaController = new PeliculaController(peliculaView, peliculaRepository);

        SalaView salaView = new SalaView();
        SalaRepository salaRepository = new SalaRepository();
        SalaController salaController = new SalaController(salaView, salaRepository);

        ReservaView reservaView = new ReservaView();
        ReservaRepository reservaRepository = new ReservaRepository();
        ReservaController reservaController = new ReservaController(reservaView, reservaRepository, clienteController, peliculaController, salaController);

        clienteRepository.loadClientes();
        peliculaRepository.loadPeliculas();
/*
        reservaController.generarReserva();

        Scanner scanner = new Scanner(System.in);
*/
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        MenuPrincipalViewController menuPrincipalViewController = new MenuPrincipalViewController(menuPrincipalView);
        menuPrincipalView.setVisible(true);
    

        /*
        int op = -1;
        do {
            System.out.println("1- Cargar Clientes");
            System.out.println("2- Mostrar Clientes");
            System.out.println("3- ");
            System.out.println("4- ");
            System.out.println("5- ");
            System.out.println("6- ");
            System.out.println("7- Sign out");

            System.out.println("Ingrese una opción");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    Cliente cliente1 = new Cliente("41458761", "agustin cerino", 25);
                    Cliente cliente2 = new Cliente("41459812", "tomas hernandez", 28);
                    Cliente cliente3 = new Cliente("41458983", "juan carlos", 68);
                    Cliente cliente4 = new Cliente("41452161", "roberto perez", 45);

                    clienteRepository.registrar(cliente1);
                    clienteRepository.registrar(cliente2);
                    clienteRepository.registrar(cliente3);
                    clienteRepository.registrar(cliente4);

                    break;
                case 2:
                    clienteController.mostrarListaClientes();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (op != 7);
        System.out.println("Programa finalizado");
        scanner.close();

         */
    }

}


