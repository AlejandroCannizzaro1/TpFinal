package org.example.Sala.View;

import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;

import javax.swing.*;
import java.util.Scanner;

public class SalaView {
    Scanner scanner = new Scanner(System.in);

    public void verButacaDisponible(Sala sala) {
        StringBuilder mensaje = new StringBuilder();
        boolean hayButacasDisponibles = false;  // Variable de control para verificar disponibilidad

        mensaje.append("Disponibilidad butacas sala " + sala.getNumeroSala() );

        for (Butaca butaca : sala.getButacas()) {
            if (butaca.getDisponibilidad().equals("DISPONIBLE")) {
                hayButacasDisponibles = true;  // Encontramos al menos una butaca disponible
                mensaje.append("[").append(butaca.getNumero()).append("] ");
            }
        }

        if (hayButacasDisponibles) {
            // Mostrar mensaje con las butacas disponibles
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Sala " + sala.getNumeroSala() , JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar mensaje de que no hay butacas disponibles
            JOptionPane.showMessageDialog(null, "No hay butacas disponibles " , "Sala " + sala.getNumeroSala(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
