package com.rcasani.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "ordenes")
public class OrdenEntity {

    @Id
    private UUID id;

    @ManyToOne
    private FarmaciaEntity farmacia;

    private Long clienteId;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<OrdenItemEntity> items;

    private String estado;

}
