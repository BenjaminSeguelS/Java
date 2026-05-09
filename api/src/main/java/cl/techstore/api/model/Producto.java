package cl.techstore.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(length = 255)
    private String descripcion;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false) // clp
    private Integer stock;
    @Column (nullable = false, length = 50)
    private String categoria;
    @Column (nullable = false)
    private boolean activo = true;
}
