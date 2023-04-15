package com.latam.alura.tienda.repositories;

import java.util.List;

public interface CrudRepository <T>{
/*T valor cualquiera para ser utilizada por cualquier entidad*/
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);

}
