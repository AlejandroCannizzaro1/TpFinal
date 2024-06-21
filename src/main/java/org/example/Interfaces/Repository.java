package org.example.Interfaces;

public interface Repository<T> {

    void registrar(T obj);
    T consultar(String id);
    void actualizar(String id, T obj);
    void eliminar(String id);
}

