package org.example;


import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.IntegracionDeSwing.View.GestionClientesView;
import org.example.IntegracionDeSwing.Controller.GestionClientesViewController;
import org.example.IntegracionDeSwing.View.MenuPrincipalView;
import org.example.IntegracionDeSwing.Controller.MenuPrincipalViewController;
import org.example.Pelicula.Controller.PeliculaController;
import org.example.Pelicula.Model.Repository.PeliculaRepository;
import org.example.Pelicula.View.PeliculaView;
import org.example.Reserva.Controller.ReservaController;
import org.example.Reserva.Model.Repository.ReservaRepository;
import org.example.Reserva.View.ReservaView;
import org.example.Sala.Controller.SalaController;
import org.example.Sala.Model.Repository.SalaRepository;
import org.example.Sala.View.SalaView;

public class Main {
    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(clienteRepository, clienteView,
               new GestionClientesView() );

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






        /*
                int op = -1;
        do {
            System.out.println("1- Menu Cliente");
            System.out.println("2- Menu Pelicula");
            System.out.println("3- Menu Sala");
            System.out.println("4- Menu Reserva");
            System.out.println("5- Sign out");

            System.out.println("Ingrese una opción");
            op = scanner.nextInt(); // Leer la entrada como cadena
            switch (op) {
                case 1:

                    int op1 = -1;
                    do {
                        System.out.println("1- Mostrar Clientes");
                        System.out.println("2- Cargar Cliente Manual");
                        System.out.println("3- Buscar un Cliente");
                        System.out.println("4- Actualizar un Cliente");
                        System.out.println("5- Eliminar un Cliente");
                        System.out.println("6- Sign out");

                        System.out.println("Ingrese una opción");
                        op1 = scanner.nextInt();
                        switch (op1) {
                            case 1:
                                clienteController.mostrarListaClientes();
                                break;
                            case 2:
                                clienteController.cargarClienteManual();
                                break;
                            case 3:
                                clienteController.buscarCliente();
                                break;
                            case 4:
                                clienteController.actualizarCliente();
                                break;
                            case 5:
                                clienteController.eliminarCliente();
                                break;
                            case 6:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        }
                    } while (op1 != 6);
                    break;

                case 2:
                    int op2 = -1;
                    do {
                        System.out.println("1- Cargar Pelicula Manual");
                        System.out.println("2- Mostrar Peliculas");
                        System.out.println("3- Buscar una Pelicula");
                        System.out.println("4- Actualizar una Pelicula");
                        System.out.println("5- Eliminar una Pelicula");
                        System.out.println("6- Sign out");

                        System.out.println("Ingrese una opción");
                        op2 = scanner.nextInt();
                        switch (op2) {
                            case 1:
                                peliculaController.cargarPeliculaManual();
                                break;
                            case 2:
                                peliculaController.mostrarListPeliculas();
                                break;
                            case 3:
                                peliculaController.buscarPelicula();
                                break;
                            case 4:
                                peliculaController.actualizarPelicula();
                                break;
                            case 5:
                                peliculaController.eliminarPelicula();
                                break;
                            case 6:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        }
                    }while (op2 != 6);

                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }while (op != 5);
        System.out.println("Programa finalizado");
        scanner.close();
    }

         */
    }

}


