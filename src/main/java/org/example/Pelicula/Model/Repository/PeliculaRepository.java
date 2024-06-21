package org.example.Pelicula.Model.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Interfaces.Repository;
import org.example.Pelicula.Model.Entity.Pelicula;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PeliculaRepository implements Repository<Pelicula> {
    private ArrayList<Pelicula> listaPeliculas;
    private static final String FILE_PATH = "src/main/resources/peliculas.json";
    private Gson gson = new Gson();

    //---------------------------------------- CONSTRUCTOR GETTER SETTER -----------------------------------------------//

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public PeliculaRepository() {
        this.loadPeliculas();
    }

    //-------------------------------------------------- JSON ---------------------------------------------------------//

    public void loadPeliculas() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type arrayType = new TypeToken<ArrayList<Pelicula>>() {
            }.getType();
            listaPeliculas = gson.fromJson(reader, arrayType);
            if (listaPeliculas == null) {
                listaPeliculas = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            listaPeliculas = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePeliculas() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(listaPeliculas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------- METODOS --------------------------------------------------------//


    @Override
    public void registrar(Pelicula obj) {
        listaPeliculas.add(obj);
        savePeliculas();
    }

    @Override
    public void actualizar(String id, Pelicula obj) {
        Pelicula peliculaAactualizar = this.consultar(id);
        int pos = listaPeliculas.indexOf(peliculaAactualizar);
        this.listaPeliculas.set(pos, obj);
        savePeliculas();
    }

    @Override
    public Pelicula consultar(String id) {
        for (Pelicula unaPelicula : this.listaPeliculas) {
            if (unaPelicula.getTitulo().equals(id)) {
                return unaPelicula;
            }
        }
        return null;
    }

    @Override
    public void eliminar(String id) {
        this.listaPeliculas.remove(this.consultar(id));
        savePeliculas();
    }


}
