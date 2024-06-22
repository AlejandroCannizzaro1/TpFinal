package org.example.Validaciones;

import org.example.Excepciones.Excepciones;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Validar {
    private String cadena;
    private int num;
    private Integer id;

    Scanner scanner = new Scanner(System.in);


    public int mes(String mensaje) throws Excepciones {
        try {
            String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Mes", JOptionPane.PLAIN_MESSAGE);
            this.num = Integer.parseInt(input);
            if (this.num <= 0 || this.num > 12) {
                mostrarError("Ingrese un mes válido...");
                throw new Excepciones("Ingrese un mes válido...");
            }
        } catch (NumberFormatException e) {
            mostrarError("Ingrese un mes válido...");
            throw new Excepciones("Ingrese un mes válido...");
        }
        return this.num;
    }

    public int dia(String mensaje, int mes) throws Excepciones {
        try {
            String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Día", JOptionPane.PLAIN_MESSAGE);
            this.num = Integer.parseInt(input);
            boolean ok = true;
            if (!(this.num > 0 && this.num <= 31)) {
                ok = false;
            }
            if (this.num == 31 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
                ok = false;
            }
            if (this.num == 30 && mes == 2) {
                ok = false;
            }
            if (this.num > 28 && mes == 2) {
                ok = false;
            }
            if (!ok) {
                mostrarError("El día ingresado no corresponde a un mes válido...");
                throw new Excepciones("El día ingresado no corresponde a un mes válido...");
            }
        } catch (NumberFormatException e) {
            mostrarError("El día ingresado no corresponde a un mes válido...");
            throw new Excepciones("El día ingresado no corresponde a un mes válido...");
        }
        return this.num;
    }

    public int hora(String mensaje) throws Excepciones {
        try {
            String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Hora", JOptionPane.PLAIN_MESSAGE);
            this.num = Integer.parseInt(input);
            if (!(this.num >= 0 && this.num < 24)) {
                mostrarError("Ingrese una hora válida...");
                throw new Excepciones("Ingrese una hora válida...");
            }
        } catch (NumberFormatException e) {
            mostrarError("Ingrese una hora válida...");
            throw new Excepciones("Ingrese una hora válida...");
        }
        return num;
    }

    public int minutos(String mensaje) throws Excepciones {
        try {
            String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Minutos", JOptionPane.PLAIN_MESSAGE);
            this.num = Integer.parseInt(input);
            if (!(this.num >= 0 && this.num < 60)) {
                mostrarError("Ingrese un minuto válido...");
                throw new Excepciones("Ingrese un minuto válido...");
            }
        } catch (NumberFormatException e) {
            mostrarError("Ingrese un minuto válido...");
            throw new Excepciones("Ingrese un minuto válido...");
        }
        return num;
    }

    public String letras(String mensaje) throws Excepciones {
        String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Texto", JOptionPane.PLAIN_MESSAGE);
        this.cadena = input != null ? input.trim() : "";
        if (this.cadena.isEmpty()) {
            mostrarError("El campo no puede estar vacío...");
            throw new Excepciones("El campo no puede estar vacío...");
        } else if (!this.cadena.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*")) {
            mostrarError("Ingrese solo letras...");
            throw new Excepciones("Ingrese solo letras...");
        }
        return this.cadena;
    }

    public Integer numerosInt(String mensaje) throws Excepciones {
        try {
            String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Número", JOptionPane.PLAIN_MESSAGE);
            this.id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            mostrarError("Ingrese solo números...");
            throw new Excepciones("Ingrese solo números...");
        }
        return this.id;
    }

    public String numerosString(String mensaje) throws Excepciones {
        String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Número", JOptionPane.PLAIN_MESSAGE);
        this.cadena = input != null ? input.trim() : "";
        if (this.cadena.isEmpty()) {
            mostrarError("El campo no puede estar vacío...");
            throw new Excepciones("El campo no puede estar vacío...");
        }
        if (!this.cadena.matches("\\d+")) {
            mostrarError("Ingrese solo números...");
            throw new Excepciones("Ingrese solo números...");
        }
        return this.cadena;
    }

    public String validarPelicula(String mensaje, ArrayList<Pelicula> lista) throws Excepciones {
        String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Título de Película", JOptionPane.PLAIN_MESSAGE);
        this.cadena = input != null ? input.trim() : "";
        boolean ok = false;
        for (Pelicula pelicula : lista) {
            if (pelicula.getTitulo().equals(this.cadena)) {
                ok = true;
            }
        }
        if (!ok) {
            mostrarError("La película ingresada no corresponde a una registrada...");
            throw new Excepciones("La película ingresada no corresponde a una registrada...");
        }
        return this.cadena;
    }

    public int validarButacas(String mensaje, ArrayList<Butaca> butacas) throws Excepciones {
        try {
            String input = JOptionPane.showInputDialog(null, mensaje, "Ingresar Número de Butaca", JOptionPane.PLAIN_MESSAGE);
            this.id = Integer.parseInt(input);
            if (!(this.id >= 0 && this.id < butacas.size())) {
                mostrarError("Esa butaca no existe...");
                throw new Excepciones("Esa butaca no existe...");
            }
            for (Butaca butaca : butacas) {
                if (butaca.getNumero() == this.id && butaca.getDisponibilidad().equals("OCUPADA")) {
                    mostrarError("Esa butaca está ocupada...");
                    throw new Excepciones("Esa butaca está ocupada...");
                }
            }
        } catch (NumberFormatException e) {
            mostrarError("Esa butaca no existe...");
            throw new Excepciones("Esa butaca no existe...");
        }
        return id;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

