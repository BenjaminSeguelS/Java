package cl.techstore.api.service;

import cl.techstore.api.model.Producto;
import cl.techstore.api.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// ... (imports)
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarpProductos(){
        return productoRepository.findByActivoTrue();
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto modificaProducto(Long id, Producto detalles){
        // Corregido: El lanzamiento de la excepción debe ir dentro de orElseThrow [cite: 50]
        Producto productoExistente = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        productoExistente.setNombre(detalles.getNombre());
        productoExistente.setDescripcion(detalles.getDescripcion());
        productoExistente.setPrecio(detalles.getPrecio());
        productoExistente.setStock(detalles.getStock());
        productoExistente.setCategoria(detalles.getCategoria());
        return productoRepository.save(productoExistente);
    }

    public void borrarProducto(Long id){
        Producto productoExistente = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        productoExistente.setActivo(false); // Borrado lógico [cite: 205-206]
        productoRepository.save(productoExistente);
    }
}