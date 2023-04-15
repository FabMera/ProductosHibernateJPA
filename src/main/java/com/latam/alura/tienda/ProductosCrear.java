package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.math.BigDecimal;

public class ProductosCrear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        /*el orden es getTransaction().begin,em.persist(instancia de la clase),em.Transaction().commit esto para que se ejecute */
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
            Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
            em.getTransaction().begin();
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(BigDecimal.valueOf(precio));
            em.persist(producto);
            em.getTransaction().commit();
            System.out.println("Producto creado con exito con el id: " + producto.getId());
            producto = em.find(Producto.class, producto.getId());
            System.out.println(producto);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();   // Print the exception stack trace
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
