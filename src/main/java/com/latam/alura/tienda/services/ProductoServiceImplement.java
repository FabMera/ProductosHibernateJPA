package com.latam.alura.tienda.services;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.repositories.CrudRepository;
import com.latam.alura.tienda.repositories.ProductoRepositorio;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImplement implements ProductoService {
    private EntityManager em;
    private CrudRepository<Producto> repository;

    public ProductoServiceImplement(EntityManager em) {
        this.em = em;
        this.repository = new ProductoRepositorio(em);
    }

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    //Optional es un contenedor que puede contener un valor o no contener nada (null) y es una forma de evitar el NullPointerException
    // cuando no existe un objeto o es null con este clase se permite crear este tipo de objetos en caso que no se encuentren
    //util para buscar por ID que no existe
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Producto producto) {

        try {
            em.getTransaction().begin();
            repository.guardar(producto);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {

        try {
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}