package org.example.Sala.Controller;

import org.example.Cliente.Model.Entity.Cliente;
import org.example.Cliente.View.ClienteView;
import org.example.Excepciones.Excepciones;
import org.example.Sala.Model.Entity.Butaca;
import org.example.Sala.Model.Entity.Sala;
import org.example.Sala.Model.Repository.SalaRepository;
import org.example.Sala.View.SalaView;
import org.example.Validaciones.Validar;

import java.util.Scanner;

public class SalaController {
    private SalaView salaView;
    private SalaRepository salaRepository;

    Scanner scanner = new Scanner(System.in);
    Validar validar = new Validar();
    ClienteView clienteView = new ClienteView();

    public SalaController(SalaView salaView, SalaRepository salaRepository) {
        this.salaView = salaView;
        this.salaRepository = salaRepository;
    }

    public SalaView getSalaView() {
        return salaView;
    }

    public void setSalaView(SalaView salaView) {
        this.salaView = salaView;
    }

    public SalaRepository getSalaRepository() {
        return salaRepository;
    }

    public void setSalaRepository(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public void elegirButacas(Cliente cliente, Sala sala) {
        int idButaca;
        char seguir;
        do {
            salaView.verButacaDisponible(sala);
            if ((idButaca = validarButacas(sala)) != -1) { // me fijo si hay butacas disponibles
                sala.getButacas().get(idButaca).setDisponibilidad("OCUPADA");
                sala.getButacas().get(idButaca).setCliente(cliente);
                System.out.print("\nSi desea reservar otra butaca presione 's': ");
                seguir = scanner.next().charAt(0);
            } else {
                System.out.println("no hay mas butacas disponibles...");
                seguir = 'n';
            }
        } while (seguir == 's');
    }

    public int validarButacas(Sala sala) {
        boolean ok = false;
        int flag = 0;
        int num = 0;
        for (Butaca butaca : sala.getButacas()) { // determino si hay butacas disponibles
            if (butaca.getDisponibilidad().equals("DISPONIBLE")) {
                flag = 1;
            }
        }
        if (flag == 1) {
            while (!ok) {
                try {
                    num = validar.validarButacas("Elija butaca a reservar: ", sala.getButacas());
                    ok = true;
                } catch (Excepciones e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            return -1;
        }
        return num;
    }

    public void crearSala() {
        Sala sala1 = new Sala(1, "DISPONIBLE");
        salaRepository.addSala(sala1);
        Sala sala2 = new Sala(2, "DISPONIBLE");
        salaRepository.addSala(sala2);
        Sala sala3 = new Sala(3, "DISPONIBLE");
        salaRepository.addSala(sala3);
    }
}
