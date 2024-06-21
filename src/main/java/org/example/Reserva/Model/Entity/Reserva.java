package org.example.Reserva.Model.Entity;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Pelicula.Model.Entity.Pelicula;
import org.example.Sala.Model.Entity.Sala;

import java.util.Objects;

public class Reserva {

    private int id;
    private Cliente cliente;
    private Pelicula pelicula;
    private Sala sala;

    public Reserva(int id, Cliente cliente, Pelicula pelicula, Sala sala) {
        this.id = id;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Reserva reserva = (Reserva) object;
        return id == reserva.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
