package org.example.Cliente.Controller;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.Swing.GestionClientesView;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteView clienteView;

    private GestionClientesView gestionClientesView;

    public ClienteController(ClienteRepository clienteRepository, ClienteView clienteView, GestionClientesView gestionClientesView) {
        this.clienteRepository = clienteRepository;
        this.clienteView = clienteView;
        this.gestionClientesView = gestionClientesView;
    }

    public ClienteRepository getClienteRepository() {
        return clienteRepository;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public void setClienteView(ClienteView clienteView) {
        this.clienteView = clienteView;
    }

    public void cargarCliente(Cliente unCliente){
        clienteRepository.registrar(unCliente);
    }

    public void cargarClienteManual(){
        boolean existe = true;
        Cliente cliente = clienteView.cargarClienteManual(gestionClientesView);
        if(cliente != null){
            existe = clienteRepository.consultarSiExisteClienteEnLista(cliente.getDni());

            if (!existe){
                this.clienteRepository.registrar(cliente);
                this.gestionClientesView.mostrarCliente(this.gestionClientesView, cliente);
                JOptionPane.showMessageDialog(null, "Cliente cargado con exito", "Clientes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El cliente ya existe en la lista", "Clientes", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrarListaClientes(){

        HashSet<Cliente> listaClientes = clienteRepository.getListaClientes();

        if(!listaClientes.isEmpty()){
            gestionClientesView.mostrarListaClientes(gestionClientesView, listaClientes);
        } else {
            JOptionPane.showMessageDialog(null, "Lista de clientes vacia", "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void buscarCliente(){

        Cliente clienteEncontrado = clienteRepository.consultar(clienteView.pedirDniCliente(gestionClientesView));

        if (clienteEncontrado != null) {
            gestionClientesView.mostrarCliente(gestionClientesView, clienteEncontrado);
        }else {
            clienteView.mensaje1();
        }
    }

    public void eliminarCliente(){

        String dni = clienteView.pedirDniCliente(gestionClientesView);
        clienteRepository.eliminar(dni);

        clienteRepository.saveClientes();

    }

    public void actualizarCliente(){

        String dni = clienteView.pedirDniCliente(gestionClientesView);
        Cliente clienteActualizado = clienteView.cargarClienteManual(gestionClientesView);
        clienteRepository.actualizar(dni, clienteActualizado);

        clienteRepository.saveClientes();
    }


}
