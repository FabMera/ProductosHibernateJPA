package com.latam.alura.tienda.services;

import com.latam.alura.tienda.modelo.Producto;

import java.util.List;
import java.util.Optional;

public  interface ProductoService {
    /*La interface service la usamos como un patron de diseño, ESPECIALIZADA EN LOGICA DE NEGOCIOS*/
    List<Producto> listar();
    /*Optional es una clase que se utiliza para evitar la excepcion nullpointerException cuando no existe un objeto o es null
    * con este clase se permite crear este tipo de objetos en caso que no se encuentren*/
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);
}
