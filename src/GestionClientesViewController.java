package org.example.IntegracionDeSwing.View;

import org.example.Cliente.Controller.ClienteController;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionClientesViewController {
    private GestionClientesView gestionClientesView;
    ClienteRepository clienteRepository = new ClienteRepository();
    ClienteView clienteView = new ClienteView();

    ClienteController clienteController = new ClienteController(clienteRepository, clienteView);


    public GestionClientesViewController(GestionClientesView gestionClientesView, ClienteController clienteController) {
        this.gestionClientesView = gestionClientesView;
        this.clienteController = clienteController;


        // Agregar el listener al botón de la vista
        this.gestionClientesView.addAgregarClienteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarClienteManual();
            }
        });
    }

    public void cargarClienteManual(){

        clienteRepository.registrar(clienteView.cargarClienteManual(gestionClientesView));
    }

}
