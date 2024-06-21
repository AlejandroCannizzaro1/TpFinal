package org.example.Pelicula.Controller;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.IntegracionDeSwing.View.GestionPeliculasView;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Pelicula.Model.Repository.PeliculaRepository;
import org.example.Pelicula.View.PeliculaView;

import javax.swing.*;
import java.util.Date;

public class PeliculaController {
    PeliculaView peliculaView;
    PeliculaRepository peliculaRepository;
GestionPeliculasView gestionPeliculasView = new GestionPeliculasView();

    //---------------------------------------- CONSTRUCTOR GETTER SETTER -----------------------------------------------//
    public PeliculaController(PeliculaView peliculaView, PeliculaRepository peliculaRepository) {
        this.peliculaView = peliculaView;
        this.peliculaRepository = peliculaRepository;
    }

    public PeliculaView getPeliculaView() {
        return peliculaView;
    }

    public void setPeliculaView(PeliculaView peliculaView) {
        this.peliculaView = peliculaView;
    }

    public PeliculaRepository getPeliculaRepository() {
        return peliculaRepository;
    }

    public void setPeliculaRepository(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    //-------------------------------------------------METODOS----------------------------------------------------------//


    public void cargarPeliculaManual(){
        peliculaRepository.registrar(peliculaView.crearPelicula(gestionPeliculasView));
    }

    public void mostrarListPeliculas(){
        for (Object pelicula : getPeliculaRepository().getListaPeliculas()) {
            Pelicula pelicula1 = (Pelicula) pelicula;
            peliculaView.verPelicula(pelicula1);
        }
    }

    public void buscarPelicula() {
        Pelicula unaPelicula = peliculaRepository.consultar(peliculaView.pedirTitulo(gestionPeliculasView));
        if (unaPelicula != null) {
            peliculaView.verPelicula(unaPelicula);
        }
    }

    public void actualizarPelicula(){

        Pelicula peliculaAactualizar = peliculaRepository.consultar(peliculaView.pedirTitulo(gestionPeliculasView));

        if ( peliculaAactualizar != null) {

            peliculaRepository.actualizar(peliculaAactualizar.getTitulo(), peliculaView.crearPelicula(gestionPeliculasView));
            System.out.println("La Actualizacion fue exitosa!");

        }
        else {
            System.out.println("El libro ingresado no existe!");
        }
    }

    public void eliminarPelicula(){
        peliculaRepository.eliminar(peliculaView.pedirTitulo(gestionPeliculasView));
        System.out.println("El Libro se elimino con exito!");

    }

    public void mostrarPelisFuturo(Date fecha){
        for (Object pelicula : getPeliculaRepository().getListaPeliculas()) {
            Pelicula pelicula1 = (Pelicula) pelicula;
            if(pelicula1.getFechasYhoras().getTime() > fecha.getTime()) {
                peliculaView.verPelicula(pelicula1);
            }
        }
    }


}