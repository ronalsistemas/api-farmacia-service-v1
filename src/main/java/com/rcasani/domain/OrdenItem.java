package com.rcasani.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdenItem {
    private final Long productoId;
    private final String productoNombre;
    private final int cantidad;
    private final String descripcion;
}
