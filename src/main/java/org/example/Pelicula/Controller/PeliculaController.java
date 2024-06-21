package org.example.Pelicula.Controller;

import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Pelicula.Model.Repository.PeliculaRepository;
import org.example.Pelicula.View.PeliculaView;

import java.util.Date;

public class PeliculaController {
    private PeliculaView peliculaView;
    private PeliculaRepository peliculaRepository;


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

    public void mostrarListPeliculas(){
        for (Object pelicula : getPeliculaRepository().getListaPeliculas()) {
            Pelicula pelicula1 = (Pelicula) pelicula;
            peliculaView.verPelicula(pelicula1);
        }
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
