package com.rcasani.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orden_items")
public class OrdenItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId;
    private String productoNombre;
    private int cantidad;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenEntity orden;
}
