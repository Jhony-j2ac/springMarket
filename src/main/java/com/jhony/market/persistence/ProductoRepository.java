package com.jhony.market.persistence;

import com.jhony.market.domain.Product;
import com.jhony.market.domain.repository.ProductRepository;
import com.jhony.market.persistence.crud.ProductoCrudRepository;
import com.jhony.market.persistence.entity.Producto;
import com.jhony.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
        return  mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos =  productCrudRepository.findByIdCategoria(categoryId);
        return Optional.of( mapper.toProducts(productos) );
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = Optional.ofNullable(productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true));
        return  productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(prods -> mapper.toProduct(prods));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productCrudRepository.save(mapper.toProducto(product));
        return mapper.toProduct(producto);
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }

    /*public  List<Producto> getByName(String name){
        return (List<Producto>) productCrudRepository.findByName(name);
    }*/


}
