package com.jhony.market.persistence.crud;

import com.jhony.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Metodo de consultas personalizadas
    @Query(value = "select * from productos where id = ?", nativeQuery = true )
    List<Producto> getProducto(Integer id);

    //Metodo con nativo queryMethod
    List<Producto> findByNombre(String name);

    List<Producto> findByIdCategoria(Integer id);


    List<Producto> findByCantidadStockLessThanAndEstado(Integer cantidad, Boolean estado);

}
