package org.example.Sala.Model.Entity;

import java.util.ArrayList;

public class Sala {
    private int numeroSala;
    private ArrayList<Butaca> butacas;

    public Sala(int numeroSala) {
        this.numeroSala = numeroSala;
        this.butacas = new ArrayList<>();
        addButacas();
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public ArrayList<Butaca> getButacas() {
        return butacas;
    }

    public void setButacas(ArrayList<Butaca> butacas) {
        this.butacas = butacas;
    }

    public void addButacas(){
        for (int i=0; i<5; i++){
            Butaca butaca = new Butaca(i, "DISPONIBLE");
            butacas.add(butaca);
        }
    }

}

