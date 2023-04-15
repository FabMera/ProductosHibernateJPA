package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductosListarWhere {
    public static void main(String[] args) {
//        EntityManager em = JpaUtil.getEntityManager();
//        Query query=em.createQuery("select p from Producto p where p.nombre =?1", Producto.class);
//        query.setParameter(1, "macbook");
//        /*getSingleResult funciona solamente si traemos 1 objeto que cumpla la condicion ,se utiliza el objeto p pero si son mas hay que crear una lista */
//        Producto p =(Producto) query.getSingleResult();
//        System.out.println(p);
//        em.close();
        //Otra forma de consultar mas registros que se repiten puede ser :
        Scanner scanner = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select p from Producto p where p.nombre =?1", Producto.class);
        System.out.println("Ingrese el nombre del producto : ");
        String nombreP = scanner.next();
        query.setParameter(1, nombreP);
        List<Producto> productos = query.getResultList();
        System.out.println(productos);
        em.close();


    }
}
