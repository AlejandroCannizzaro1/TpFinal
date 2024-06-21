package org.example.Pelicula.Model.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Interfaces.Repository;
import org.example.Pelicula.Model.Entity.Pelicula;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PeliculaRepository<T extends Pelicula> implements Repository<T> {
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
        this.listaPeliculas = new ArrayList<>();
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
    public void registrar(T obj) {
        listaPeliculas.add(obj);
        savePeliculas();
    }

    @Override
    public T consultar(String titulo) {
        for (Pelicula pelicula : this.listaPeliculas) {
            if (pelicula.getTitulo().equals(titulo)) {
                return (T) pelicula;
            }
        }
        return null;
    }

    public void actualizar(int pos, Pelicula pelicula) {
        this.listaPeliculas.set(pos, pelicula);
        savePeliculas();
    }

    public void eliminar(Pelicula pelicula) {
        this.listaPeliculas.remove(pelicula);
        savePeliculas();
    }

    @Override
    public void eliminar(String id) { // no lo utilizo

    }

    @Override
    public void actualizar(String id, T obj) { // no lo utilizo

    }
}
