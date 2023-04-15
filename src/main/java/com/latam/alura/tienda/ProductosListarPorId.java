package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.EntityManager;


import java.util.Scanner;

public class ProductosListarPorId {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del producto : ");

        Long id = scanner.nextLong();
        EntityManager em = JpaUtil.getEntityManager();

        /*Query query=em.createQuery("select p from Producto p where p.id =?1", Producto.class);*/
        Producto producto = em.find(Producto.class, id);
        System.out.println(producto);
        em.close();

        /*getSingleResult funciona solamente si traemos 1 objeto que cumpla la condicion ,se utiliza el objeto p pero si son mas hay que crear una lista */


    }
}
