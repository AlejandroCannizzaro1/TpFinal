package org.example.Pelicula.View;

import org.example.Excepciones.Excepciones;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Sala.Model.Entity.Sala;
import org.example.Validaciones.Validar;

import java.util.Date;
import java.util.Scanner;

public class PeliculaView {
    Validar validar = new Validar();

    Scanner scanner = new Scanner(System.in);

    public Pelicula crearPelicula() {


        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();
        System.out.print("Duracion: ");
        int duracion = scanner.nextInt();
        System.out.print("[Fecha] ");
        int mes = validarMes();
        int dia = validarDia(mes);
        int horas = validarHora();
        int minuto = validarMinuto();
        Date fecha = new Date(124, (mes-1), dia, horas, minuto);

        return new Pelicula(titulo, genero, duracion, fecha, new Sala());
    }

    // --------------------------------------------- VALIDACIONES ------------------------------------------------------//
    public int validarMes() {
        int mes = 0;
        boolean ok = false;
        while (!ok) {
            try {
                mes = validar.mes("Mes (en numero): ");
                ok = true;
            } catch (Excepciones e) {
                System.out.println(e.getMessage());
            }
        }
        return mes;
    }

    public int validarDia(int mes) {
        int dia = 0;
        boolean ok = false;
        while (!ok) {
            try {
                dia = validar.dia("Dia (en numero): ", mes);
                ok = true;
            } catch (Excepciones e) {
                System.out.println(e.getMessage());
            }
        }
        return dia;
    }

    public int validarHora(){
        int hora = 0;
        boolean ok = false;
        while(!ok){
            try{
                hora = validar.hora("Hora: ");
                ok = true;
            } catch (Excepciones e) {
                System.out.println(e.getMessage());
            }
        }
        return hora;
    }

    public int validarMinuto(){
        int min = 0;
        boolean ok = false;
        while(!ok){
            try{
                min = validar.minutos("Minutos: ");
                ok = true;
            } catch (Excepciones e) {
                System.out.println(e.getMessage());
            }
        }
        return min;
    }

    public String pedirTitulo() {
        System.out.println("Ingrese el Titulo de la Pelicula buscada:");
       String titulo = scanner.nextLine();

       return titulo;
    }

    // ----------------------------------------------- MOSTRAR ---------------------------------------------------------//
    public void verPelicula(Pelicula pelicula) {
        System.out.println(pelicula.getTitulo() + " - " + pelicula.getFechasYhoras());
    }

    /*
       public Pelicula crearPelicula(JFrame parent) {
        System.out.println("--------CREACION DE PELICULA--------");

        String titulo = validarTitulo(parent);
        String genero = validarGenero(parent);
        int duracion = validarDuracion(parent);

        System.out.print("Fecha de la Funcion\n");
        int mes = validarMes(parent);
        int dia = validarDia(parent, mes);
        int horas = validarHora(parent);
        int minuto = validarMinuto(parent);

        Date fecha = new Date(124, (mes - 1), dia, horas, minuto);

        return new Pelicula(titulo, genero, duracion, fecha);
    }

    public String pedirTitulo(JFrame parent) {
        return JOptionPane.showInputDialog(parent, "Ingrese el Titulo de la Pelicula buscada:");
    }

    // --------------------------------------------- VALIDACIONES ------------------------------------------------------//

    public String validarTitulo(JFrame parent) {
        boolean ok = false;
        String titulo = "";
        while (!ok) {
            try {
                titulo = JOptionPane.showInputDialog(parent, "Ingrese el Titulo:");
                if (titulo == null || titulo.trim().isEmpty()) {
                    throw new Excepciones("El titulo no puede estar vacío.");
                }
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return titulo;
    }

    public String validarGenero(JFrame parent) {
        boolean ok = false;
        String genero = "";
        while (!ok) {
            try {
                genero = JOptionPane.showInputDialog(parent, "Ingrese el Genero:");
                if (genero == null || genero.trim().isEmpty()) {
                    throw new Excepciones("El genero no puede estar vacío.");
                }
                // Puedes agregar más validaciones para el genero si es necesario
                ok = true;
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return genero;
    }

    public int validarDuracion(JFrame parent) {
        boolean ok = false;
        int duracion = 0;
        while (!ok) {
            try {
                String duracionStr = JOptionPane.showInputDialog(parent, "Ingrese la Duracion en Minutos:");
                if (duracionStr == null || duracionStr.trim().isEmpty()) {
                    throw new Excepciones("La duración no puede estar vacía.");
                }
                duracion = Integer.parseInt(duracionStr);
                if (duracion <= 0) {
                    throw new Excepciones("La duración debe ser un número positivo.");
                }
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return duracion;
    }

    public int validarMes(JFrame parent) {
        boolean ok = false;
        int mes = 0;
        while (!ok) {
            try {
                String mesStr = JOptionPane.showInputDialog(parent, "Ingrese el Numero de Mes:");
                if (mesStr == null || mesStr.trim().isEmpty()) {
                    throw new Excepciones("El mes no puede estar vacío.");
                }
                mes = Integer.parseInt(mesStr);
                if (mes < 1 || mes > 12) {
                    throw new Excepciones("El mes debe estar entre 1 y 12.");
                }
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return mes;
    }

    public int validarDia(JFrame parent, int mes) {
        boolean ok = false;
        int dia = 0;
        while (!ok) {
            try {
                String diaStr = JOptionPane.showInputDialog(parent, "Ingrese el Numero de Dia:");
                if (diaStr == null || diaStr.trim().isEmpty()) {
                    throw new Excepciones("El día no puede estar vacío.");
                }
                dia = Integer.parseInt(diaStr);
                if (dia < 1 || dia > 31) { // Simplificación; puedes agregar más lógica según el mes
                    throw new Excepciones("El día debe estar entre 1 y 31.");
                }
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return dia;
    }

    public int validarHora(JFrame parent) {
        boolean ok = false;
        int hora = 0;
        while (!ok) {
            try {
                String horaStr = JOptionPane.showInputDialog(parent, "Ingrese la Hora:");
                if (horaStr == null || horaStr.trim().isEmpty()) {
                    throw new Excepciones("La hora no puede estar vacía.");
                }
                hora = Integer.parseInt(horaStr);
                if (hora < 0 || hora > 23) {
                    throw new Excepciones("La hora debe estar entre 0 y 23.");
                }
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return hora;
    }

    public int validarMinuto(JFrame parent) {
        boolean ok = false;
        int minuto = 0;
        while (!ok) {
            try {
                String minutoStr = JOptionPane.showInputDialog(parent, "Ingrese los Minutos:");
                if (minutoStr == null || minutoStr.trim().isEmpty()) {
                    throw new Excepciones("Los minutos no pueden estar vacíos.");
                }
                minuto = Integer.parseInt(minutoStr);
                if (minuto < 0 || minuto > 59) {
                    throw new Excepciones("Los minutos deben estar entre 0 y 59.");
                }
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Excepciones excepciones) {
                JOptionPane.showMessageDialog(parent, excepciones.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return minuto;
    }

    // ----------------------------------------------- MOSTRAR ---------------------------------------------------------//
    public void verPelicula(Pelicula pelicula) {
        JOptionPane.showMessageDialog(null,
                "--------------------------\n" +
                        "Titulo: " + pelicula.getTitulo() + "\n" +
                        "Genero: " + pelicula.getGenero() + "\n" +
                        "Duracion: " + pelicula.getDuracion() + " minutos\n" +
                        "Fecha: " + pelicula.getFechasYhoras() + "\n" +
                        "--------------------------",
                "Detalles de la Película",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
     */
}
