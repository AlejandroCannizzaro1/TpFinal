package org.example.Cliente.Controller;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Cliente.Model.Repository.ClienteRepository;
import org.example.Cliente.View.ClienteView;
import org.example.Excepciones.Excepciones;
import org.example.IntegracionDeSwing.View.GestionClientesView;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.*;

public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteView clienteView;
    private GestionClientesView gestionClientesView;

    public ClienteController(ClienteRepository clienteRepository, ClienteView clienteView,
                             GestionClientesView gestionClientesView) {
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


  /*  public void cargarClienteManual(){

        clienteRepository.registrar(clienteView.cargarClienteManual());
    }
*/
    public void mostrarListaClientes(){
        Set<Cliente> listaClientes = clienteRepository.getListaClientes();

        for (Cliente unCliente: listaClientes){
            clienteView.mostrarCliente(unCliente);
        }
    }
    public  void actualizarClienteController (JFrame parent) {
        Integer opcion = -1;
        String dni = this.clienteView.consultarDNIClienteView(parent);
        if(!dni.equals("")){
            Cliente cliente = clienteRepository.consultar(dni);
            if(cliente != null){
                opcion = this.clienteView.menuActualizarCliente(parent);
                if (opcion != -1){
                    Cliente clienteUpdated = this.clienteView.actualizaCliente(opcion, cliente, parent);
                    if (clienteUpdated != null){
                        this.clienteRepository.actualizar(dni,cliente);
                    } else {
                        System.out.println("\nError al actualizar campos del cliente !! ");
                    }
                } else {
                    System.out.println("\nLa opcion no es valida !! ");
                }
            } else {
                System.out.println("El cliente no existe !! ");
            }
        } else {
            System.out.println("Error al tipear id !! ");
        }
    }


  /*  public void buscarCliente(){

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
*/

}
