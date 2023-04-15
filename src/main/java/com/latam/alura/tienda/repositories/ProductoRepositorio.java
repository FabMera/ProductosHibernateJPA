package com.latam.alura.tienda.repositories;

import com.latam.alura.tienda.modelo.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductoRepositorio implements CrudRepository<Producto> {
    //Inyeccion de dependencias
    private final EntityManager em;

    //Constructor
    public ProductoRepositorio(EntityManager em) {
        this.em = em;
    }

    //Listar todos los productos
    @Override
    public List<Producto> listar() {
        return em.createQuery("select p from Producto p", Producto.class).getResultList();
    }

    //buscar por ID
    @Override
    public Producto porId(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) {
        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = porId(id);
        em.remove(producto);
    }
}
