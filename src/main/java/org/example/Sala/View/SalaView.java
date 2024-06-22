package org.example.Sala.View;

import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;

import javax.swing.*;
import java.util.Scanner;

public class SalaView {
    Scanner scanner = new Scanner(System.in);

    public void verButacaDisponible(Sala sala) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Butacas disponibles:\n");

        for (Butaca butaca : sala.getButacas()) {
            if (butaca.getDisponibilidad().equals("DISPONIBLE")) {
                mensaje.append("[").append(butaca.getNumero()).append("] ");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Butacas Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }
    /*public void verButacaDisponible(Sala sala){
        System.out.println("Butacas disponibles");
        for (Butaca butaca : sala.getButacas()) {
            if(butaca.getDisponibilidad().equals("DISPONIBLE")){
                System.out.print("[" + butaca.getNumero() + "] ");
            }
        }
    } */
}
