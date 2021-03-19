package edu.escuelaing.arep.server.model;

public class Participante {

    int id, edad;
    String name, categoria;

    public Participante(int id, int edad, String name, String categoria){
        this.id = id;
        this.edad = edad;
        this. name = name;
        this. categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
