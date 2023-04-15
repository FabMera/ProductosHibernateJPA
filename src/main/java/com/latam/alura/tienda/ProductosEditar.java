package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.math.BigDecimal;

public class ProductosEditar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del producto a editar"));
            Producto producto = em.find(Producto.class, id);
            String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto: ", producto.getNombre());
            String descripcion = JOptionPane.showInputDialog("Ingrese la nueva descripcion  del producto : ", producto.getDescripcion());
            Double precio= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto: ", producto.getPrecio()));
            em.getTransaction().begin();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(BigDecimal.valueOf(precio));
            em.merge(producto);
            em.getTransaction().commit();
            System.out.println("Producto editado con exito" + producto.getId());
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
