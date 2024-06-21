package org.example.Sala.View;

import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;

import java.util.Scanner;

public class SalaView {
    Scanner scanner = new Scanner(System.in);

    public Sala crearSala(){
        System.out.print("Numero de sala: ");
        return new Sala(scanner.nextInt()); // (agregar validaciones)
    }

    public void verButacaDisponible(Sala sala){
        System.out.println("Butacas disponibles");
        for (Butaca butaca : sala.getButacas()) {
            if(butaca.getDisponibilidad().equals("DISPONIBLE")){
                System.out.print("[" + butaca.getNumero() + "] ");
            }
        }
    }
}
