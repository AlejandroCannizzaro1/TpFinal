package org.example.Cliente.Controller;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.Swing.GestionClientesView;

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
        clienteRepository.registrar(clienteView.cargarClienteManual());
    }

    public void mostrarListaClientes(){

        HashSet<Cliente> listaClientes = clienteRepository.getListaClientes();
        gestionClientesView.mostrarListaClientes(gestionClientesView, listaClientes);

    }


    public void buscarCliente(){

        Cliente clienteEncontrado = clienteRepository.consultar(clienteView.pedirDniCliente());

        if (clienteEncontrado != null) {
            clienteView.mostrarCliente(clienteEncontrado);
        }else {
            clienteView.mensaje1();
        }
    }

    public void eliminarCliente(){

        String dni = clienteView.pedirDniCliente();
        clienteRepository.eliminar(dni);

        clienteRepository.saveClientes();

    }

    public void actualizarCliente(){

        String dni = clienteView.pedirDniCliente();
        Cliente clienteActualizado = clienteView.cargarClienteManual();
        clienteRepository.actualizar(dni, clienteActualizado);

        clienteRepository.saveClientes();
    }


}
