package cl.techstore.api.Repository;

import cl.techstore.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //muestra productos activos (borrado logico)
    List<Producto> findByActivoTrue();
}
