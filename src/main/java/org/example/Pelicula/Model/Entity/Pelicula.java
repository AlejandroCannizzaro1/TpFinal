package org.example.Pelicula.Model.Entity;
import java.util.Date;


public class Pelicula {

    private String titulo;
    private String genero;
    private int duracion; // Duración en minutos
    private Date fechasYhoras;  //o lo dividimos en dos

    public Pelicula(String titulo, String genero, int duracion, Date fechasYhoras) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.fechasYhoras = fechasYhoras;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFechasYhoras() {
        return fechasYhoras;
    }

    public void setFechasYhoras(Date fechasYhoras) {
        this.fechasYhoras = fechasYhoras;
    }


}
