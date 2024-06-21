package org.example.Cliente.View;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Excepciones.Excepciones;
import org.example.Excepciones.Validar;

import java.util.Scanner;
import javax.swing.*;

public class ClienteView {

    Validar validar = new Validar();

    Scanner scanner = new Scanner(System.in);

    public void mensaje1() {
        System.out.println("El Cliente buscado no existe!");
    }

    public void mostrarCliente(Cliente unCliente) {
        System.out.println("--------------------------");
        System.out.println("DNI Cliente: " + unCliente.getDni());
        System.out.println("Nombre y Apellido: " + unCliente.getNombreYapellido());
        System.out.println("Edad: " + unCliente.getEdad());
        System.out.println("--------------------------");
    }


    public Cliente cargarClienteManual(JFrame parent) {
        System.out.println("--------CREACION DE CLIENTE--------");

        String dni = validarDni(parent);
        String nombreYapellido = validarNombreYapellido(parent);
        int edad = validarEdad(parent);

        return new Cliente(dni, nombreYapellido, edad);
    }
    public String eliminarCliente (JFrame parent) {
        String id = "";
        Boolean ok = false;
        System.out.println("--------ELIMINACION DE CLIENTE--------");
        while (!ok) {
            try {
                id = JOptionPane.showInputDialog(parent, "Ingrese el id del cliente que desea eliminar");
                if (id == null || id.trim().isEmpty()) {
                    throw new Excepciones("El id no puede estar vacío.");
                }
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return id;
    }

    public String consultarDNIClienteView (JFrame parent) {
        String dni = "";
        Boolean ok = false;
        System.out.println("--------CONSULTAR DNI CLIENTE--------");
        while (!ok) {
            try {
                dni = JOptionPane.showInputDialog(parent, "Ingrese el dni del cliente que desea consultar");
                if (dni == null || dni.trim().isEmpty()) {
                    throw new Excepciones("El id no puede estar vacío.");
                }
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return dni;
    }

    public String validarNombreYapellido(JFrame parent) {
        boolean ok = false;
        String nombre = "";
        while (!ok) {
            try {
                nombre = JOptionPane.showInputDialog(parent, "Ingrese el Nombre y Apellido del Cliente:");
                if (nombre == null || nombre.trim().isEmpty()) {
                    throw new Excepciones("El nombre no puede estar vacío.");
                }
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return nombre;
    }

    public int validarEdad(JFrame parent) {
        boolean ok = false;
        int edad = 0;
        while (!ok) {
            try {
                String edadStr = JOptionPane.showInputDialog(parent, "Ingrese la Edad del Cliente:");
                if (edadStr == null || edadStr.trim().isEmpty()) {
                    throw new Excepciones("La edad no puede estar vacía.");
                }
                edad = Integer.parseInt(edadStr);
                if (edad <= 0) {
                    throw new Excepciones("La edad debe ser un número positivo.");
                }
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return edad;
    }

    public String validarDni(JFrame parent) {
        boolean ok = false;
        String dni = "";
        while (!ok) {
            try {
                dni = JOptionPane.showInputDialog(parent, "Ingrese el DNI del Cliente:");
                if (dni == null || dni.trim().isEmpty()) {
                    throw new Excepciones("El DNI no puede estar vacío.");
                }
                // Aquí podrías agregar más validaciones para el DNI
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return dni;
    }
public  int menuActualizarCliente (JFrame parent){
        String dni = this.validarDni(parent);
    int opcion = -1;
        if(!dni.equals("")) {
            do {
                try {
                    String opcionStr = JOptionPane.showInputDialog(parent,
                            "Selecciona una opción para actualizar:\n"
                                    + "1- Modificar Nombre\n"
                                    + "2- Modificar DNI\n"
                                    + "3- Modificar Edad\n\n"
                                    + "Elija una opción:");

                    if (opcionStr == null || opcionStr.trim().isEmpty()) {
                        throw new Excepciones("Debe ingresar una opción válida.");
                    }

                    opcion = Integer.parseInt(opcionStr);

                    if (opcion < 1 || opcion > 3) {
                        throw new Excepciones("La opción debe estar entre 1 y 3.");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Excepciones excepcion) {
                    JOptionPane.showMessageDialog(parent, excepcion.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (opcion < 1 || opcion > 3);
        }
        return opcion;
    }


        public Cliente actualizaCliente(Integer opcion, Cliente cliente, JFrame parent) {
            if (opcion != -1) {
                switch (opcion) {
                    case 1:
                        String nuevoNombre = validarNombreYapellido(parent);
                        cliente.setNombreYapellido(nuevoNombre);
                        break;
                    case 2:
                        String nuevoDni = validarDni(parent);
                        cliente.setDni(nuevoDni);
                        break;
                    case 3:
                        int nuevaEdad = validarEdad(parent);
                        cliente.setEdad(nuevaEdad);
                        break;
                    default:
                        break;
                }
                return cliente;
            } else {
                return null;
            }
        }

}



   /* public Cliente cargarClienteManual(){
        System.out.println("--------CREACION DE CLIENTE--------");

        String dni = validarDni();
        String nombreYapellido = validarNombreYapellido();
        int edad = validarEdad();

        return new Cliente(dni, nombreYapellido, edad);
    }

    public String validarNombreYapellido(){
        boolean ok = false;
        String nombre = "";
        while(!ok){
            try{
                nombre = validar.letras("Ingrese el Nombre y Apellido del Cliente: ");
                ok=true;
            }catch (Excepciones excepciones){
                System.out.println(excepciones.getMessage());
            }
        }
        return nombre;
    }

    public int validarEdad(){
        boolean ok = false;
        int edad = 0;
        while(!ok){
            try{
                edad = validar.numerosInt("Ingrese la Edad del Cliente: ");
                ok=true;
            }catch (Excepciones excepciones){
                System.out.println(excepciones.getMessage());
            }
        }
        return edad;
    }

    public String validarDni(){
        boolean ok = false;
        String dni = "";
        while(!ok){
            try{
                dni = validar.numerosString("Ingrese el DNI del Cliente: ");
                ok=true;
            }catch (Excepciones excepciones){
                System.out.println(excepciones.getMessage());
            }
        }
        return dni;
    }


    public String pedirDniCliente(){
        boolean ok = false;
        String dni = "";
        while(!ok){
            try{
                dni = validar.numerosString("Ingrese el DNI del Cliente buscado: ");
                ok=true;
            }catch (Excepciones excepciones){
                System.out.println(excepciones.getMessage());
            }
        }
        return dni;
    }*/







