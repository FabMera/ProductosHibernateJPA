package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class ProductosDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del producto a eliminar : ");
        Long id = scanner.nextLong();
        EntityManager em = JpaUtil.getEntityManager();

        try {
            Producto producto = em.find(Producto.class, id);
            em.getTransaction().begin();
            em.remove(producto);
            em.getTransaction().commit();
            System.out.println("Producto eliminado con exito");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
