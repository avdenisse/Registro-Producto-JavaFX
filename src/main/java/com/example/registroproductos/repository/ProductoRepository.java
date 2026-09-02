package com.example.registroproductos.repository;

import com.example.registroproductos.model.Producto;

import java.time.LocalDate;
import java.util.List;

public class ProductoRepository {
    public List<Producto> findAll(){
        return List.of(
                new Producto(
                        1,
                        "Monitor Samsung",
                        "Tecnologico",
                        600.63,
                        LocalDate.of(2026,9,1),
                        null
                ),
                new Producto(
                        1,
                        "Sillon",
                        "Hogar",
                        700.63,
                        LocalDate.of(2026,9,2),
                        null
                ),
                new Producto(
                        3,
                        "Falda",
                        "Ropa",
                        50.63,
                        LocalDate.of(2026,9,3),
                        null
                ),
                new Producto(
                        4,
                        "Silla Gamer",
                        "Oficina",
                        200.50,
                        LocalDate.of(2026,9,4),
                        null
                ),
                new Producto(
                        5,
                        "Leche",
                        "Lacteos",
                        1000.63,
                        LocalDate.of(2026,9,5),
                        null
                )

        );
    }
}
