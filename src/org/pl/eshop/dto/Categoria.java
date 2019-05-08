package org.pl.eshop.dto;

public class Categoria {

    private Integer id;
    private String nombre;
    private String descripcion;

    public Categoria() {
        this.nombre = "";
    }

    public Categoria(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id== null || id <= 0)
            throw new IllegalArgumentException();
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty() || nombre.length() < 3)
            throw new IllegalArgumentException();
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
