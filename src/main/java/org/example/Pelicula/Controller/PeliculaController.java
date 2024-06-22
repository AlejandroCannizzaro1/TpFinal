package org.example.Pelicula.Controller;

import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Pelicula.Model.Repository.PeliculaRepository;
import org.example.Pelicula.View.PeliculaView;
import org.example.Sala.Controller.SalaController;

import java.util.Date;

public class PeliculaController {
    private PeliculaView peliculaView;
    private PeliculaRepository peliculaRepository;
    private SalaController salaController;


    //---------------------------------------- CONSTRUCTOR GETTER SETTER -----------------------------------------------//
    public PeliculaController(PeliculaView peliculaView, PeliculaRepository peliculaRepository, SalaController salaController) {
        this.peliculaView = peliculaView;
        this.peliculaRepository = peliculaRepository;
        this.salaController = salaController;
    }

    public PeliculaView getPeliculaView() {
        return peliculaView;
    }

    public SalaController getSalaController() {
        return salaController;
    }

    public void setSalaController(SalaController salaController) {
        this.salaController = salaController;
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
        peliculaRepository.registrar(peliculaView.crearPelicula());
    }
    public void mostrarListPeliculas(){
        for (Object pelicula : getPeliculaRepository().getListaPeliculas()) {
            Pelicula pelicula1 = (Pelicula) pelicula;
            peliculaView.verPelicula(pelicula1);
        }
    }

    public void buscarPelicula() {
        Pelicula unaPelicula = peliculaRepository.consultar(peliculaView.pedirTitulo());
        if (unaPelicula != null) {
            peliculaView.verPelicula(unaPelicula);
        }
    }

    public void actualizarPelicula(){

        Pelicula peliculaAactualizar = peliculaRepository.consultar(peliculaView.pedirTitulo());

        if ( peliculaAactualizar != null) {

            peliculaRepository.actualizar(peliculaAactualizar.getTitulo(), peliculaView.crearPelicula());
            System.out.println("La Actualizacion fue exitosa!");

        }
        else {
            System.out.println("La Pelicula ingresado no existe!");
        }
    }

    public void eliminarPelicula(){
        peliculaRepository.eliminar(peliculaView.pedirTitulo());
        System.out.println("La Pelicula se elimino con exito!");

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
