package org.example.Validaciones;

import org.example.Excepciones.Excepciones;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;

import java.util.ArrayList;
import java.util.Scanner;

public class Validar {
    private String cadena;
    private int num;
    private Integer id;

    Scanner scanner = new Scanner(System.in);

    public int mes(String mensaje) throws Excepciones {
        System.out.print(mensaje);
        this.num = scanner.nextInt();
        boolean ok = false;
        if (this.num < 12 && this.num > 0) {
            ok = true;
        }
        if (!ok) {
            throw new Excepciones("Ingrese un mes valido...");
        }
        return this.num;
    }

    public int dia(String mensaje, int mes) throws Excepciones {
        System.out.print(mensaje);
        boolean ok = true;
        this.num = scanner.nextInt();
        if (!(this.num > 0 && this.num < 31)) {
            ok = false;
        }
        if (this.num == 31 && mes == 1 || mes == 3 || mes == 5 || mes == 8 || mes == 10) {
            ok = false;
        }
        if (this.num == 30 && mes == 1) {
            ok = false;
        }
        if (!ok) {
            throw new Excepciones("El dia ingresado no corresponde a un mes valido...");
        }
        return this.num;
    }

    public int hora(String mensaje) throws Excepciones {
        System.out.print(mensaje);
        this.num = scanner.nextInt();
        if (!(this.num < 24 && this.num > 0)) {
            throw new Excepciones("Inrgese una hora valida...");
        }
        return num;
    }

    public int minutos(String mensaje) throws Excepciones {
        System.out.print(mensaje);
        this.num = scanner.nextInt();
        if (!(this.num < 60 && this.num > 0)) {
            throw new Excepciones("Inrgese un minuto valido...");
        }
        return num;
    }

    public String letras(String mensaje) throws Excepciones {
        System.out.print(mensaje);
        this.cadena = scanner.nextLine().trim();

        if (this.cadena.isEmpty()) {
            throw new Excepciones("El campo no puede estar vacio...");
        } else if (!this.cadena.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*")) {
            throw new Excepciones("Ingrese solo letras...");
        }

        return this.cadena;
    }

    public Integer numerosInt(String mensaje) throws Excepciones {
        System.out.print(mensaje);

        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            throw new Excepciones("Ingrese solo números...");
        }

        this.id = scanner.nextInt();
        scanner.nextLine();

        return this.id;
    }

    public String numerosString(String mensaje) throws Excepciones {
        System.out.print(mensaje);
        this.cadena = scanner.nextLine();

        if (this.cadena.isEmpty()) {
            throw new Excepciones("El campo no puede estar vacio...");
        }

        if (!this.cadena.matches("\\d+")) {
            throw new Excepciones("Ingrese solo números...");
        }
        return this.cadena;
    }

    public String validarPelicula(String mensaje, ArrayList<Pelicula> lista) throws Excepciones {
        System.out.print(mensaje);
        this.cadena = scanner.nextLine();
        boolean ok = false;
        for (Pelicula pelicula : lista) {
            if (pelicula.getTitulo().equals(this.cadena)) {
                ok = true;
            }
        }
        if (!ok) {
            throw new Excepciones("La pelicula ingresada no corresponde a una registrada...");
        }
        return this.cadena;
    }

    public int validarButacas(String mensaje, ArrayList<Butaca> butacas) throws Excepciones {
        System.out.print(mensaje);
        this.id = scanner.nextInt();
        if (!(this.id < butacas.size() && this.id > -1)) {
            throw new Excepciones("Esa butaca no existe...");
        }
        for (Butaca butaca : butacas) {
            if (butaca.getNumero() == this.id) {
                if (butaca.getDisponibilidad().equals("OCUPADA")){
                    throw new Excepciones("Esa butaca esta ocupada...");
                }
            }
        }
        return id;
    }
}
