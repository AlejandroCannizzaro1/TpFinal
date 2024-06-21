package org.example.Sala.Controller;

import org.example.Sala.Model.Entity.Sala;
import org.example.Sala.Model.Repository.SalaRepository;
import org.example.Sala.View.SalaView;

import java.util.Scanner;

public class SalaController {
    private SalaView salaView;
    private SalaRepository salaRepository;

    Scanner scanner = new Scanner(System.in);

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

    public void elegirButacas(int indexSala) { // (no olvidarse validar)
        int idButaca;
        char seguir;
        do {
            for (Sala sala : salaRepository.getListaSalas()) {
                if(sala.getNumeroSala() == indexSala) {
                    salaView.verButacaDisponible(sala);
                    System.out.print("Que butaca desea reservar?: ");
                    idButaca = scanner.nextInt();
                    sala.getButacas().get(idButaca).setDisponibilidad("OCUPADA");
                }
            }
            System.out.print("\nSi desea reservar otra butaca presione 's': ");
            seguir = scanner.next().charAt(0);
        } while (seguir == 's');
    }
}
