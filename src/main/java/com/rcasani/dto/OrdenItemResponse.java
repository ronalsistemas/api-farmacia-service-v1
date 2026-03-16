package com.rcasani.dto;

public record OrdenItemResponse(
        Long productoId,
        String productoNombre,
        int cantidad,
        String descripcion
) {
}
