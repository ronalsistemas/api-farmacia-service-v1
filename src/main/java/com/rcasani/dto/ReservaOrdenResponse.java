package com.rcasani.dto;

import java.util.List;
import java.util.UUID;

public record ReservaOrdenResponse(
        UUID ordenId,
        Long farmaciaId,
        Long clienteId,
        List<OrdenItemResponse> items
) {
}
