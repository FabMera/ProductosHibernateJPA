package com.latam.alura.tienda.modelo;

import jakarta.persistence.*;

import java.lang.Long;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name="productos")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    @Column(name="fechacreacion")
    private final LocalDate fechaCreacion = LocalDate.now();
    /*@ManyToOne
    private Categoria categoria;*/


    public String getNombre() {
        return nombre;
    }
    public Producto(){

    }
    public Producto(String nombre, String descripcion, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }


    @Override
    public String toString() {
        return "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio;
    }
}
