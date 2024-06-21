package org.example.Pelicula.View;

import org.example.Excepciones.Excepciones;
import org.example.Excepciones.Validar;
import org.example.Pelicula.Model.Entity.Pelicula;

import java.util.Date;
import java.util.Scanner;

public class PeliculaView {
    Validar validar = new Validar();

    public Pelicula crearPelicula() {
        Scanner scanner = new Scanner(System.in);


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

        return new Pelicula(titulo, genero, duracion, fecha);
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

    // ----------------------------------------------- MOSTRAR ---------------------------------------------------------//
    public void verPelicula(Pelicula pelicula) {
        System.out.println(pelicula.getTitulo() + " - " + pelicula.getFechasYhoras());
    }

}
