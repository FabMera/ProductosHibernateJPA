package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductosListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Producto> productos = em.createQuery("select p from Producto p",Producto.class).getResultList();
        productos.forEach(System.out::println);
        em.close();
    }
}