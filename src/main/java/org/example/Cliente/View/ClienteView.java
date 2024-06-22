package org.example.Cliente.View;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Excepciones.Excepciones;
import org.example.Validaciones.Validar;

import javax.swing.*;
import java.util.Scanner;

public class ClienteView {

    Validar validar = new Validar();

    Scanner scanner = new Scanner(System.in);
    public void mensaje1(){
        System.out.println("El Cliente buscado no existe!");
    }

    public void mostrarCliente(Cliente unCliente){
        System.out.println("--------------------------");
        System.out.println("DNI Cliente: " + unCliente.getDni());
        System.out.println("Nombre y Apellido: " + unCliente.getNombreYapellido());
        System.out.println("Edad: " + unCliente.getEdad());
        System.out.println("--------------------------");
    }

    public Cliente cargarClienteManual(){
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
    }

/*
    public String validarNombreYapellido(JFrame parent) {
        boolean ok = false;
        String nombre = "";
        while (!ok) {
            try {
                nombre = JOptionPane.showInputDialog(parent, "Ingrese el Nombre y Apellido:");
                if (nombre == null || nombre.trim().isEmpty()) {
                    throw new Excepciones("El Nombre y Apellido no puede estar vacío.");
                } else if (!nombre.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*")){
                    throw new Excepciones("Ingrese solo letras...");
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
                }        if (!dni.matches("\\d+")){
                    throw new Excepciones("Ingrese solo números...");
                }
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return dni;
    }
 */


}


