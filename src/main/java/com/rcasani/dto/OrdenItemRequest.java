package com.rcasani.dto;

public record OrdenItemRequest(
        Long productoId,
        String productoNombre,
        int cantidad,
        String descripcion
) {
}
