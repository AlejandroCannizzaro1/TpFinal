package org.example.Sala.Model.Entity;

public class Butaca {
    private int numero;
    private String disponibilidad;

    public Butaca(int numero, String disponibilidad) {
        this.numero = numero;
        this.disponibilidad = disponibilidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
