package com.example.registroproductos.model;

import java.time.LocalDate;

public class Producto {
    private int Id;
    private String nombre;
    private String Categoria;
    private double precio;
    private LocalDate FechaRegistro;
    private String ImagePath;

    public Producto(){

    }

    public Producto(int id, String nombre, String categoria, double precio, LocalDate fechaRegistro, String imagePath) {
        Id = id;
        this.nombre = nombre;
        Categoria = categoria;
        this.precio = precio;
        FechaRegistro = fechaRegistro;
        ImagePath = imagePath;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
