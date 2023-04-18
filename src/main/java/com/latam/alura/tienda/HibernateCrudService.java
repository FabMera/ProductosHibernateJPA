package com.latam.alura.tienda;

import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.services.ProductoService;
import com.latam.alura.tienda.services.ProductoServiceImplement;
import com.latam.alura.tienda.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        ProductoService service = new ProductoServiceImplement(em);


        System.out.println("================Listar===================");
        List<Producto> productos = service.listar();
        productos.forEach(System.out::println); // System.out::println es un metodo de referencia LAMBDA

        System.out.println("================Buscar por ID=============");
        Optional<Producto> optionalProducto = service.porId(9L);
        optionalProducto.ifPresent(System.out::println); //ifPresent es un metodo de referencia LAMBDA que se ejecuta si el objeto es diferente de null


        System.out.println("===========Guardar nuevo Producto=========");
        Producto producto = new Producto();
        producto.setNombre("Macbook Pro 2021");
        producto.setPrecio(new BigDecimal("9800.00"));
        producto.setDescripcion("Laptop de 16 pulgadas");

        service.guardar(producto);
        System.out.println("Producto guardado con exito");
        service.listar().forEach(System.out::println);

        System.out.println("===========Editar Producto===============");
        Long id = producto.getId();
        optionalProducto = service.porId(id);
        optionalProducto.ifPresent(p -> {
            p.setNombre("Macbook Pro ");
            p.setPrecio(new BigDecimal("9800.00"));
            p.setDescripcion("Laptop 2022");
            service.guardar(p);
            System.out.println("Producto editado con exito");
            service.listar().forEach(System.out::println);
        });

        System.out.println("===========Eliminar Producto===============");
        id = producto.getId();
        optionalProducto = service.porId(id);
        //puede ser un IF o un IF PRESENT CON LAMBDA
        optionalProducto.ifPresent(p -> {
            service.eliminar(p.getId());
            System.out.println("Producto eliminado con exito");
            service.listar().forEach(System.out::println);
        });
        em.close();

    }
}
