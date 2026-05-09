package cl.techstore.api.service;

import cl.techstore.api.model.Producto;
import cl.techstore.api.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    //muestra productos activos (borrado logico)
    public List<Producto> listarpProductos(){
        return productoRepository.findByActivoTrue();
    }
    //cera productos
    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }
    //modificar producto existente
    public Producto modificaProducto(Long id, Producto detalles){
        Producto Producto = productoRepository.findById(id).orElseThrow() ;
        new RuntimeException("Producto no encontrado");
        Producto.setNombre(detalles.getNombre());
        Producto.setDescripcion(detalles.getDescripcion());
        Producto.setPrecio(detalles.getPrecio());
        Producto.setStock(detalles.getStock());
        Producto.setCategoria(detalles.getCategoria());
        return productoRepository.save(Producto);
    }
    //borrado logico
    public void borrarProducto(Long id){
        Producto Producto = productoRepository.findById(id).orElseThrow() ;
        new RuntimeException("Producto no encontrado");
        Producto.setActivo(false);
        productoRepository.save(Producto);
    }

}
