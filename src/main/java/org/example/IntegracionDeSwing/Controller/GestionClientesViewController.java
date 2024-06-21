package org.example.IntegracionDeSwing.Controller;

import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.IntegracionDeSwing.View.GestionClientesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionClientesViewController {
    private GestionClientesView gestionClientesView;
    ClienteRepository clienteRepository = new ClienteRepository();
    ClienteView clienteView = new ClienteView();
    ClienteController clienteController = new ClienteController(clienteRepository, clienteView,
            gestionClientesView);


    public GestionClientesViewController(GestionClientesView gestionClientesView) {
        this.gestionClientesView = gestionClientesView;


        // Agregar el listener al botón de la vista
        this.gestionClientesView.addAgregarClienteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarClienteManual();
            }
        });

        this.gestionClientesView.addEliminarClienteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            eliminarCliente();
            }
        });

        this.gestionClientesView.addActualizarClienteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               actualizarCliente();
            }
        });

        this.gestionClientesView.addConsultarClienteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCliente();
            }
        });
    }

    public void cargarClienteManual(){

        clienteRepository.registrar(clienteView.cargarClienteManual(gestionClientesView));
    }



        public void eliminarCliente (){
            String id = this.clienteView.eliminarCliente(gestionClientesView);
            this.clienteRepository.eliminar(id);
        }

    public void actualizarCliente (){
        clienteController.actualizarClienteController(gestionClientesView);

        }
            public void consultarCliente (){
                String id = this.clienteView.consultarDNIClienteView(gestionClientesView);
                this.clienteRepository.consultar(id);
            }

}
