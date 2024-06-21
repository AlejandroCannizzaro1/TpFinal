package org.example.Cliente.View;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Excepciones.Excepciones;
import org.example.Excepciones.Validar;

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




}


