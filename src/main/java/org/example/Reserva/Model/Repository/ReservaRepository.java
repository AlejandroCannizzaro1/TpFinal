package org.example.Reserva.Model.Repository;

import com.google.gson.Gson;
import org.example.Reserva.Model.Entity.Reserva;

import java.util.HashMap;
import java.util.Map;

public class ReservaRepository {
    private Map<Integer, Reserva> reservaMap;
    private static final String FILE_PATH = "src/main/resources/reservas.json";
    private Gson gson = new Gson();

    public ReservaRepository(){
        this.reservaMap = new HashMap<>();
    }

    public Map<Integer, Reserva> getReservaMap() {
        return reservaMap;
    }

    public void setReservaMap(Map<Integer, Reserva> reservaMap) {
        this.reservaMap = reservaMap;
    }

    public void agregarReserva(Integer key, Reserva reserva){
        reservaMap.put(key, reserva); // hacer el json y guardarlo
        System.out.println("RESERVADO CON EXITO!!!");
    }
}
